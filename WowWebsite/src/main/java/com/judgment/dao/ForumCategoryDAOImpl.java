/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumCategory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author snurrg
 */
@Repository
@Transactional
public class ForumCategoryDAOImpl implements ForumCategoryDAO {

    private static final String FIND_BY_NAME_JPQL = "Select fc from ForumCategory fc where fc.name = :name";

    @Autowired
    private EntityManager em;

    @Override
    public ForumCategory findByName(String name) {

        TypedQuery<ForumCategory> theQuery = em.createQuery(FIND_BY_NAME_JPQL, ForumCategory.class);
        theQuery.setParameter("name", name);

        ForumCategory forumCategory = null;

        try {
            forumCategory = theQuery.getSingleResult();
        } catch (Exception e) {
            forumCategory = null;
        }

        return forumCategory;
    }
}
