package com.example.oaes_login.dao;

import com.example.oaes_login.entity.User;

import java.util.List;

public interface UserDao {
    public User findByUserId(long userId) throws Exception;
    public void save(User user) throws Exception;
    public User findByEmail(String email) throws Exception;
}