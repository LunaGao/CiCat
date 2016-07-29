package com.cicat.entity.mapper;

import com.cicat.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lunagao on 16/7/26.
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserName(resultSet.getString("userName"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
