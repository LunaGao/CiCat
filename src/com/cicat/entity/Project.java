package com.cicat.entity;

/**
 * Created by lunagao on 16/7/28.
 */
public class Project {
    private int idProject;
    private String name;
    private String platform;
    private String git_url;
    private String git_branch;
    private String git_username;
    private String git_password;

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

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getGit_branch() {
        return git_branch;
    }

    public void setGit_branch(String git_branch) {
        this.git_branch = git_branch;
    }

    public String getGit_username() {
        return git_username;
    }

    public void setGit_username(String git_username) {
        this.git_username = git_username;
    }

    public String getGit_password() {
        return git_password;
    }

    public void setGit_password(String git_password) {
        this.git_password = git_password;
    }
}
