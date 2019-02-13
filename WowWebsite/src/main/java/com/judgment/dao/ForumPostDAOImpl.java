/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumPost;
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
public class ForumPostDAOImpl implements ForumPostDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FIND_BY_ID_JPQL = "Select fp from ForumPost fp where fp.id = :id";

    @Autowired
    private EntityManager em;

    @Override
    public ForumPost findById(Long id) {

        TypedQuery<ForumPost> query = em.createQuery(FIND_BY_ID_JPQL, ForumPost.class);

        ForumPost forumPost = null;

        try {
            forumPost = query.setParameter("id", id).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findById: -> {}", e.getMessage());
        }

        return forumPost;
    }

    @Override
    public void create(ForumPost forumPost) {

        em.persist(forumPost);
    }

    @Override
    public void update(ForumPost forumPost) {

        try {
            em.merge(forumPost);
        } catch (Exception e) {
            logger.info("updateForumPost: -> {}", e.getMessage());
        }
    }
}
