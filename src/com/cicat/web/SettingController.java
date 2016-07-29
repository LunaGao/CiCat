package com.cicat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lunagao on 16/7/27.
 */
@Controller
public class SettingController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String showSetting(ModelMap model) {
        return "setting";
    }

}
