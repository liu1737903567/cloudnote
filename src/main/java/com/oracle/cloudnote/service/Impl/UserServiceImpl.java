package com.oracle.cloudnote.service.Impl;

import com.oracle.cloudnote.bean.User;
import com.oracle.cloudnote.dao.UserDao;
import com.oracle.cloudnote.service.UserService;
import com.oracle.cloudnote.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean register(User user) {
        User u = userDao.findByName(user.getName());
        if(u != null){
            return  false;
        }
        String id = UUID.randomUUID().toString();
        user.setPassword(id);
        user.setPassword(Md5Util.md5(user.getPassword()));
        userDao.add(user);
        return true;
    }

    @Override
    public boolean checkUsername(String name) {
        User user = userDao.findByName(name);
        if(user != null){
            return  true;
        }else {
            return false;
        }
    }
}
