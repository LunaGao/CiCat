package com.cicat.service;

import com.cicat.entity.Project;
import java.util.List;

/**
 * Created by lunagao on 16/7/28.
 */
public interface IProjectService {

    void create(String name, String platform);
    List<Project> getProjects();
    Project getProject(String name, String platform);
    void updateProjectSourceCode(Project project);
    void updateProjectSetting(Project project);

}
