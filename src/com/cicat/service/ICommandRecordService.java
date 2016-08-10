package com.cicat.service;

import com.cicat.entity.Command;

import java.util.List;

/**
 * Created by lunagao on 16/8/10.
 */
public interface ICommandRecordService {

    List<Command> getCommands(int projectId);
    void createCommand(Command command);
    void deleteCommand(int commandId);
    void deleteCommands(int projectId);

}
