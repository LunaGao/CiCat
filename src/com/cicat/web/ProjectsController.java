package com.cicat.web;

import com.cicat.entity.Project;
import com.cicat.service.IProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/7/27.
 */
@Controller
public class ProjectsController {

    @Resource
    IProjectService service;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String showProjects(ModelMap model) {
        List<Project> projects = service.getProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

}
