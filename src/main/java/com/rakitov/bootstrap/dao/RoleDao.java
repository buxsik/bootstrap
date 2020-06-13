package com.rakitov.bootstrap.dao;

import com.rakitov.bootstrap.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRole();
    Role getRoleByName(String name);
}
