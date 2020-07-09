package com.rakitov.bootstrap.dao;

import com.rakitov.bootstrap.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserDaoImp implements UserDao{

    private final EntityManager entityManager;

     @Override
    public List<User> getAllUser() {
        TypedQuery query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return entityManager.createQuery("select user from User user where user.email=:thisEmail", User.class)
                .setParameter("thisEmail", email)
                .getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = findUserById(id);
        entityManager.remove(user);
    }
}
