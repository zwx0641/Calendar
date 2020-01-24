package com.zeno.calendar.service;

import com.zeno.calendar.pojo.User;

public interface UserService {
    boolean queryEmailIsExist(String email);

    void saveUser(User user);

    User queryUserForLogin(String email, String password);

    void updateUserInfo(User user);
}