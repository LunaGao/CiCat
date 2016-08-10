package com.cicat.entity.mapper;

import com.cicat.entity.Command;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lunagao on 16/8/10.
 */
public class CommandMapper implements RowMapper<Command> {

    @Override
    public Command mapRow(ResultSet resultSet, int i) throws SQLException {
        Command command = new Command();
        command.setIdCommand(resultSet.getInt("idCommand"));
        command.setBuildName(resultSet.getString("buildName"));
        command.setCommandStr(resultSet.getString("commandStr"));
        command.setCommandOutput(resultSet.getString("commandOutput"));
        command.setCommandResult(resultSet.getBoolean("commandResult"));
        command.setExecTime(resultSet.getTimestamp("execTime"));
        command.setProjectId(resultSet.getInt("projectId"));
        command.setDeleted(resultSet.getBoolean("isDeleted"));
        return command;
    }

}
