package com.cicat.web;

import com.cicat.entity.Setting;
import com.cicat.service.ISettingService;
import com.cicat.utils.CommonString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunagao on 16/7/27.
 */
@Controller
public class SettingController {

    @Resource
    ISettingService service;

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String showSetting(ModelMap model) {
        List<Setting> settings = service.getSettings();
        for (Setting setting : settings) {
            model.addAttribute(setting.getSettingKey(), setting.getSettingValue());
        }
        return "setting";
    }

    @RequestMapping(value = "/setting/save", method = RequestMethod.POST)
    public String createProject(ModelMap model, @RequestParam String project_save_location, @RequestParam String git_path) {
        if (CommonString.isEmptyString(project_save_location)) {
            model.addAttribute(CommonString.KEY_PORJECT_SAVE_LOCATION, project_save_location);
            model.addAttribute(CommonString.KEY_GIT_LOCATION_PATH, git_path);
            model.addAttribute("error", "Project location can not be empty!");
            return "project/create";
        } else {
            ArrayList<Setting> settings = new ArrayList<>();
            Setting setting_project_save_location = new Setting();
            setting_project_save_location.setSettingKey("project_save_location");
            setting_project_save_location.setSettingValue(project_save_location);
            settings.add(setting_project_save_location);
            Setting setting_git_path = new Setting();
            setting_git_path.setSettingKey("git_path");
            setting_git_path.setSettingValue(git_path);
            settings.add(setting_git_path);
            service.setSettings(settings);
            return "redirect:/setting";
        }
    }

}
