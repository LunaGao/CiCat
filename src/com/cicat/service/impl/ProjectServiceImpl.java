package com.cicat.service.impl;

import com.cicat.entity.Project;
import com.cicat.entity.mapper.ProjectMapper;
import com.cicat.service.IProjectService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/7/28.
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, String platform) {
        String SQL = "INSERT INTO Project (name, platform) VALUES ( ? , ? )";
        jdbcTemplate.update( SQL, name, platform);
    }

    @Override
    public List<Project> getProjects() {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM Project";
        return jdbcTemplate.query(SQL,
                new ProjectMapper());
    }

    @Override
    public Project getProject(String name, String platform) {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM Project WHERE name = ? and platform = ?";

        List<Project> projects  = jdbcTemplate.query(SQL, new Object[]{name, platform},
                new BeanPropertyRowMapper<>(Project.class));
        if (projects != null && projects.size() >= 1) {
            return projects.get(0);
        } else {
            return null;
        }
    }
}
