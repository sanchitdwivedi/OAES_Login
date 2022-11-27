package com.example.oaes_login.service;

import com.example.oaes_login.dao.UserDao;
import com.example.oaes_login.dao.UserDaoImpl;
import com.example.oaes_login.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDaoImpl();
    }

    public void updateUser(User user) throws Exception {
        userDao.save(user);
    }

    public User getUserById(long userId) throws Exception {
        return userDao.findByUserId(userId);
    }
}
