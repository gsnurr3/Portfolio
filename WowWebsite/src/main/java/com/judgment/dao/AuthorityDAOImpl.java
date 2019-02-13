/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.Authority;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gsnurr3
 */
@Repository
@Transactional
public class AuthorityDAOImpl implements AuthorityDAO {

    private static final String FIND_BY_NAME_JPQL = "Select a from Authority a where a.authority = :name";

    @Autowired
    private EntityManager em;

    @Override
    public Authority findByName(String name) {

        TypedQuery<Authority> theQuery = em.createQuery(FIND_BY_NAME_JPQL, Authority.class);
        theQuery.setParameter("name", name);

        Authority authority = null;

        try {
            authority = theQuery.getSingleResult();
        } catch (Exception e) {
            authority = null;
        }

        return authority;
    }
}
