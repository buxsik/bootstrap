package com.rakitov.bootstrap.service;

import com.rakitov.bootstrap.dao.RoleDao;
import com.rakitov.bootstrap.dao.UserDao;
import com.rakitov.bootstrap.model.Role;
import com.rakitov.bootstrap.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Transactional
    @Override
    public void updateUser(User user, String[] roles) {
        List<String> roleList = new ArrayList<>();
        for (String role : roles) {
            String role1 = "ROLE_" + role;
            roleList.add(role1);
        }
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleList) {
            roleSet.add(roleDao.getRoleByName(role));
        }
        user.setRole(roleSet);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void saveUser(User user, String[] roles) {
        List<String> roleList = new ArrayList<>();
        for (String role : roles) {
            String role1 = "ROLE_" + role;
            roleList.add(role1);
        }
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleList) {
            roleSet.add(roleDao.getRoleByName(role));
        }
        user.setRole(roleSet);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

}
