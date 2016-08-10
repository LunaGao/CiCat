package com.cicat.entity;

import java.sql.Timestamp;

/**
 * Created by lunagao on 16/8/10.
 */
public class Command {

    private int idCommand;
    private String buildName;
    private String commandStr;
    private String commandOutput;
    private Boolean commandResult;
    private Timestamp execTime;
    private int projectId;
    private Boolean isDeleted;

    public int getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(int idCommand) {
        this.idCommand = idCommand;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getCommandStr() {
        return commandStr;
    }

    public void setCommandStr(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getCommandOutput() {
        return commandOutput;
    }

    public void setCommandOutput(String commandOutput) {
        this.commandOutput = commandOutput;
    }

    public Boolean getCommandResult() {
        return commandResult;
    }

    public void setCommandResult(Boolean commandResult) {
        this.commandResult = commandResult;
    }

    public Timestamp getExecTime() {
        return execTime;
    }

    public void setExecTime(Timestamp execTime) {
        this.execTime = execTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
