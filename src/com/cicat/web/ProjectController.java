package com.cicat.web;

import com.cicat.entity.Command;
import com.cicat.entity.Project;
import com.cicat.service.ICommandRecordService;
import com.cicat.service.IProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/7/29.
 */

@Controller
public class ProjectController {

    @Resource
    IProjectService service;
    @Resource
    ICommandRecordService commandRecordService;

    @RequestMapping(value = "/{name}/{platform}", method = RequestMethod.GET)
    public String showProject(ModelMap model, @PathVariable String name, @PathVariable String platform) {
        Project project = service.getProject(name, platform);
        model.addAttribute("project", project);
        return "/project/project";
    }

    @RequestMapping(value = "/{name}/{platform}/history", method = RequestMethod.GET)
    public String showProjectHistory(ModelMap model, @PathVariable String name, @PathVariable String platform) {
        Project project = service.getProject(name, platform);
        List<Command> commands = commandRecordService.getCommands(project.getIdProject());
        model.addAttribute("project", project);
        model.addAttribute("commands", commands);
        return "/project/history";
    }
}
