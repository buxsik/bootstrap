package com.rakitov.bootstrap.service;

import com.rakitov.bootstrap.dao.RoleDao;
import com.rakitov.bootstrap.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService{

    private final RoleDao roleDao;

    @Transactional
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
