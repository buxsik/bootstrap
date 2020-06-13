package com.rakitov.bootstrap.dao;

import com.rakitov.bootstrap.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@AllArgsConstructor
public class RoleDaoImp implements RoleDao{

    private final EntityManager entityManager;

    @Override
    public List<Role> getAllRole() {
        TypedQuery query = entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from Role role where role.name=:thisName", Role.class)
                .setParameter("thisName", name)
                .getSingleResult();
    }
}
