/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gsnurr3
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FIND_BY_USERNAME_JPQL = "Select u from User u where u.username = :username";
    private static final String FIND_BY_USERNAME_OR_BY_EMAIL_JPQL = "Select u from User u where u.username = :username or u.email = :email";
    private static final String FIND_BY_USERNAME_AND_PASSWORD_JPQL = "Select u from User u where u.username = :username and u.password = :password";
    private static final String UPDATE_PASSWORD_JPQL = "Update User u set u.password = :newPassword where u.username = :username";

    @Autowired
    private EntityManager em;

    @Override
    public User findByUsername(String username) {

        TypedQuery<User> query = em.createQuery(FIND_BY_USERNAME_JPQL, User.class);

        User user = null;

        try {
            user = query.setParameter("username", username).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findByUsername: -> {}", e.getMessage());
        }

        return user;
    }

    @Override
    public User findByUsernameOrByEmail(String username, String email) {

        TypedQuery<User> query = em.createQuery(FIND_BY_USERNAME_OR_BY_EMAIL_JPQL, User.class);

        User user = null;

        try {
            user = query.setParameter("username", username).setParameter("email", email).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findByUsernameOrByEmail: -> {}", e.getMessage());
        }

        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        TypedQuery<User> query = em.createQuery(FIND_BY_USERNAME_AND_PASSWORD_JPQL, User.class);

        User user = null;

        try {
            user = query.setParameter("username", username).setParameter("password", password).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findByUsernameAndPassword: -> {}", e.getMessage());
        }

        return user;
    }

    @Override
    public void create(User user) {

        em.persist(user);
    }

    @Override
    public int updatePassword(User user, String newPassword) {

        Query query = em.createQuery(UPDATE_PASSWORD_JPQL);

        return query.setParameter("newPassword", newPassword).setParameter("username", user.getUsername()).executeUpdate();
    }
}
