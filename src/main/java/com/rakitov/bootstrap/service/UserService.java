package com.rakitov.bootstrap.service;

import com.rakitov.bootstrap.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User findUserById(Long id);
    User findUserByEmail(String email);
    void updateUser(User user, String[] roles);
    void saveUser(User user, String[] roles);
    void removeUser(Long id);

}
