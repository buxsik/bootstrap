package com.rakitov.bootstrap.converter;

import com.rakitov.bootstrap.dao.RoleDao;
import com.rakitov.bootstrap.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleConverter implements Converter<String, Role> {

    private final RoleDao roleDao;

    @Override
    public Role convert(String name) {
        return roleDao.getRoleByName(name);
    }
}



