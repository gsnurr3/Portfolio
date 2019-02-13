/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumVote;
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
public class ForumVoteDAOImpl implements ForumVoteDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FIND_BY_ID_JPQL = "Select fv from ForumVote fv where fv.id = :id";

    @Autowired
    private EntityManager em;

    @Override
    public ForumVote findById(Long id) {

        TypedQuery<ForumVote> query = em.createQuery(FIND_BY_ID_JPQL, ForumVote.class);

        ForumVote forumVote = null;

        try {
            forumVote = query.setParameter("id", id).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            logger.info("findById: -> {}", e.getMessage());
        }

        return forumVote;
    }

    @Override
    public void create(ForumVote forumVote) {

        em.persist(forumVote);
    }
}
