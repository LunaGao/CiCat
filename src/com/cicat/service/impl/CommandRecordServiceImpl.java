package com.cicat.service.impl;

import com.cicat.entity.Command;
import com.cicat.service.ICommandRecordService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/8/10.
 */
@Service
public class CommandRecordServiceImpl implements ICommandRecordService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Command> getCommands(int projectId) {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM Command WHERE projectId = ? AND isDeleted <> TRUE ORDER BY idCommand DESC";
        return jdbcTemplate.query(SQL, new Object[]{projectId},
                new BeanPropertyRowMapper<>(Command.class));
    }

    @Override
    public void createCommand(Command command) {
        String SQL = "INSERT INTO Command (buildName, commandStr, commandOutput, commandResult, execTime, projectId, isDeleted) VALUES ( ? , ? , ? , ? , ? , ? , ?)";
        jdbcTemplate.update( SQL, command.getBuildName(), command.getCommandStr(), command.getCommandOutput(), command.getCommandResult(), command.getExecTime(), command.getProjectId(), command.getDeleted());
    }

    @Override
    public void deleteCommand(int commandId) {
        String SQL = "UPDATE Command SET isDeleted = 1 WHERE commandId = ? ";
        jdbcTemplate.update(SQL, new Object[]{commandId});
    }

    @Override
    public void deleteCommands(int projectId) {
        String SQL = "UPDATE Command SET isDeleted = 1 WHERE projectId = ? ";
        jdbcTemplate.update(SQL, new Object[]{projectId});
    }
}
