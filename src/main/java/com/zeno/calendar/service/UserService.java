package com.zeno.calendar.service;

import com.zeno.calendar.pojo.User;

public interface UserService {
    public boolean queryEmailIsExist(String email);

    public void saveUser(User user);

    public User queryUserForLogin(String email, String password);

    public void updateUserInfo(User user);
}