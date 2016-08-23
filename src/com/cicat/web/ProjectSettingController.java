package com.cicat.web;

import com.cicat.entity.Project;
import com.cicat.entity.Setting;
import com.cicat.git.GitHelper;
import com.cicat.service.ICommandRecordService;
import com.cicat.service.IProjectService;
import com.cicat.service.ISettingService;
import com.cicat.service.impl.SettingServiceImpl;
import com.cicat.utils.CommadHelper;
import com.cicat.utils.CommonString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by lunagao on 16/7/28.
 */
@Controller
public class ProjectSettingController {

    @Resource
    IProjectService service;
    @Resource
    ISettingService settingService;
    @Resource
    ICommandRecordService commandRecordService;


    @RequestMapping(value = "/project/setting/create", method = RequestMethod.GET)
    public String showCreateProjectPage(ModelMap model) {
        Project project = new Project();
        project.setName("");
        project.setPlatform("iOS");
        model.addAttribute("project", project);
        return "project/create";
    }

    @RequestMapping(value = "/project/setting/createResult", method = RequestMethod.POST)
    public String createProject(ModelMap model, @RequestParam String name, @RequestParam String platform) {
        if (CommonString.isEmptyString(name)) {
            Project project = new Project();
            project.setName(name);
            project.setPlatform(platform);
            model.addAttribute("project", project);
            model.addAttribute("error", "Project Name can not be empty");
            return "project/create";
        } else {
            service.create(name, platform);
            return "redirect:/projects";
        }
    }

    @RequestMapping(value = "/{name}/{platform}/setting", method = RequestMethod.GET)
    public String showProject(ModelMap model, @PathVariable String name, @PathVariable String platform) {
        Project project = service.getProject(name, platform);
        model.addAttribute("project", project);
        return "/project/setting";
    }

    @RequestMapping(value = "/{p_name}/{p_platform}/updateprojectsetting", method = RequestMethod.POST)
    public String updateProjectSetting(ModelMap model, @PathVariable String p_name, @PathVariable String p_platform,
                                       @RequestParam String name, @RequestParam String platform) {
        Project project = service.getProject(p_name, p_platform);
        project.setName(name);
        project.setPlatform(platform);
        service.updateProjectSetting(project);
        model.addAttribute("project", project);
        return "redirect:/" + name + "/" + platform + "/setting";
    }

    @RequestMapping(value = "/{name}/{platform}/updatesourcecode", method = RequestMethod.POST)
    public String updateSourceCode(ModelMap model, @PathVariable String name, @PathVariable String platform,
                                @RequestParam String git_url, @RequestParam String git_branch,
                                @RequestParam String git_username, @RequestParam String git_password) {
        Project project = service.getProject(name, platform);
        project.setGit_url(git_url);
        project.setGit_branch(git_branch);
        project.setGit_username(git_username);
        project.setGit_password(git_password);
        service.updateProjectSourceCode(project);
        model.addAttribute("project", project);
        return "/project/setting";
    }

    @RequestMapping(value = "/{name}/{platform}/cloneSourceCode", method = RequestMethod.GET)
    public String cloneSourceCode(ModelMap model, @PathVariable String name, @PathVariable String platform) {
        Project project = service.getProject(name, platform);
        Setting projectLocationSetting = settingService.getSetting(CommonString.KEY_PORJECT_SAVE_LOCATION);
        Setting gitLocalPathSettign = settingService.getSetting(CommonString.KEY_GIT_LOCATION_PATH);
        GitHelper gitHelper = new GitHelper(commandRecordService);
        try {
            gitHelper.cloneProject(project, projectLocationSetting, gitLocalPathSettign);
            model.addAttribute(project);
            return "redirect:setting";
        } catch (Exception ex) {
            model.addAttribute(project);
            model.addAttribute("error", ex.getMessage());
            return "/project/setting";
        }
    }

    @RequestMapping(value = "/{name}/{platform}/testBuild", method = RequestMethod.GET)
    public String testBuild(ModelMap model, @PathVariable String name, @PathVariable String platform) {
        Project project = service.getProject(name, platform);
        Setting projectLocationSetting = settingService.getSetting(CommonString.KEY_PORJECT_SAVE_LOCATION);
        try {
            String commandStr =// "cd " + projectLocationSetting.getSettingValue()
                    projectLocationSetting.getSettingValue() // test
                    + project.getPlatform()
                    + File.separator + project.getName()
                    + File.separator + "code";
//                    + " && gradle build";
            System.out.println(commandStr);
            Boolean command = CommadHelper.exeCmd(
                    "xcode build",
                    commandStr, // dir
//                    "/Users/lunagao/Android/gradle-2.12/bin/gradle build",
                    "xcode",
                    new String[] { "xcodebuild", "-sdk" ,"iphoneos9.3" },//"./run" }, //"gradle", "build" },
                    commandRecordService,
                    project.getIdProject());
            System.out.println(command);
            model.addAttribute(project);
            return "redirect:setting";
        } catch (Exception ex) {
            model.addAttribute(project);
            model.addAttribute("error", ex.getMessage());
            return "/project/setting";
        }
    }
}
