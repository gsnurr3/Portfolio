/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumThread;
import com.judgment.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author snurrg
 */
@Repository
@Transactional
public class ForumThreadDAOImpl implements ForumThreadDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FIND_BY_ID_JPQL = "Select ft from ForumThread ft where ft.id = :id";
    private static final String FIND_BY_CATEGORY_JPQL = "Select ft from ForumThread ft where ft.forumCategory.name = :category";
    private static final String FIND_BY_USERNAME_JPQL = "Select ft from ForumThread ft where ft.user = :user";

    @Autowired
    private EntityManager em;

    @Override
    public ForumThread findById(Long id) {

        TypedQuery<ForumThread> query = em.createQuery(FIND_BY_ID_JPQL, ForumThread.class);

        ForumThread forumThread = null;

        try {
            forumThread = query.setParameter("id", id).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findById: -> {}", e.getMessage());
        }

        return forumThread;
    }

    @Override
    public List<ForumThread> findByCategory(String category) {

        TypedQuery<ForumThread> query = em.createQuery(FIND_BY_CATEGORY_JPQL, ForumThread.class);

        List<ForumThread> forumThreads = new ArrayList<>();

        try {
            forumThreads = query.setParameter("category", category).getResultList();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findByCategory: -> {}", e.getMessage());
        }

        return forumThreads;
    }

    @Override
    public ForumThread findByUsername(User user) {

        TypedQuery<ForumThread> query = em.createQuery(FIND_BY_USERNAME_JPQL, ForumThread.class);

        ForumThread forumThread = null;

        try {
            forumThread = query.setParameter("user", user).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findByUsername: -> {}", e.getMessage());
        }

        return forumThread;
    }

    @Override
    public void create(ForumThread forumThread) {

        em.persist(forumThread);
    }

    @Override
    public void update(ForumThread forumThread) {

        try {
            em.merge(forumThread);
        } catch (Exception e) {
            logger.info("updateForumThread: -> {}", e.getMessage());
        }
    }
}
