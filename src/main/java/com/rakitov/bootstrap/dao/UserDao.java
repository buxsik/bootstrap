package com.rakitov.bootstrap.dao;

import com.rakitov.bootstrap.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User findUserById(Long id);
    User findUserByEmail(String email);
    void updateUser(User user);
    void saveUser(User user);
    void removeUser(Long id);
}
