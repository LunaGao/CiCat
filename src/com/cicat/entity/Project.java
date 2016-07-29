package com.cicat.entity;

/**
 * Created by lunagao on 16/7/28.
 */
public class Project {
    private int idProject;
    private String name;
    private String platform;

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
