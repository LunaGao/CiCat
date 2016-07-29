package com.cicat.web;

import com.cicat.entity.Project;
import com.cicat.service.IProjectService;
import com.cicat.utils.CommonString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by lunagao on 16/7/28.
 */
@Controller
public class ProjectSettingController {

    @Resource
    IProjectService service;

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
}
