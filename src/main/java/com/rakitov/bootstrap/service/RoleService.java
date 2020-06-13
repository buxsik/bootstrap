package com.rakitov.bootstrap.service;

import com.rakitov.bootstrap.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleByName(String name);
}
