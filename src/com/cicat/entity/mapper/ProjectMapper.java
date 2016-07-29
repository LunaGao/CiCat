package com.cicat.entity.mapper;

import com.cicat.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lunagao on 16/7/28.
 */
public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setName(resultSet.getString("name"));
        project.setIdProject(resultSet.getInt("idProject"));
        project.setPlatform(resultSet.getString("platform"));
        return project;
    }
}
