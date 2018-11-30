package com.oracle.cloudnote.dao;

import com.oracle.cloudnote.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void add(User user);
    void updatePassword(User user);
    User findByName(String name);
}
