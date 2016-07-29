package com.cicat.service.impl;

import com.cicat.entity.User;
import com.cicat.entity.mapper.UserMapper;
import com.cicat.service.IUserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/7/26.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void create(String userName, String password) {
        String SQL = "INSERT INTO User (userName, password) VALUES (?, ?)";
        jdbcTemplate.update( SQL, userName, password);
    }

    @Override
    public List<User> getUsers() {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM User";
        return jdbcTemplate.query(SQL,
                new UserMapper());
    }

    @Override
    public Boolean isCheck(String userName, String password) {
        String SQL = "SELECT count(idUser) FROM User WHERE userName = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(SQL,
                new Object[]{userName, password }, java.lang.Integer.class);
        return count >= 1;
    }

    @Override
    public Boolean checkUserAutoLogin(String userName, String lastLoginTime) {
        String SQL = "SELECT count(idUser) FROM User WHERE userName = ? AND lastLoginTime = ?";
        int count = jdbcTemplate.queryForObject(SQL,
                new Object[]{userName, lastLoginTime }, java.lang.Integer.class);
        return count >= 1;
    }

    @Override
    public User getUser(String userName) {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM User WHERE userName = ?";

        List<User> users  = jdbcTemplate.query(SQL, new Object[]{userName},
                new BeanPropertyRowMapper<>(User.class));
        if (users != null && users.size() >= 1) {
            return users.get(0);
        } else {
            return null;
        }
    }

}
