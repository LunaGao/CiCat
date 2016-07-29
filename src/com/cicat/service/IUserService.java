package com.cicat.service;

import com.cicat.entity.User;

import java.util.List;

/**
 * Created by lunagao on 16/7/26.
 */
public interface IUserService {
    void create(String userName, String password);
    List<User> getUsers();
    Boolean isCheck(String userName, String password);
    Boolean checkUserAutoLogin(String userName, String lastLoginTime);
    User getUser(String userName);
}
