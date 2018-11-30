package com.oracle.cloudnote.service;

import com.oracle.cloudnote.bean.User;

public interface UserService {
    public boolean register(User user);
    public boolean checkUsername(String name);
}
