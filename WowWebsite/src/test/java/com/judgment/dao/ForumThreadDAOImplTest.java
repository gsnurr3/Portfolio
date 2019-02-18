/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.SpringBackend.SpringBackendApplication;
import com.judgment.entity.ForumThread;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author gsnurr3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBackendApplication.class)
public class ForumThreadDAOImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ForumThreadDAOImplTest.class);

    @Autowired
    private ForumThreadDAO forumThreadDAO;

    public ForumThreadDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class ForumThreadDAOImpl.
     */
    @Test
    public void testFindById() {

    }

    /**
     * Test of findByCategory method, of class ForumThreadDAOImpl.
     */
    @Test
    @Transactional
    public void testFindByCategory() {

        List<ForumThread> forumThreads = new ArrayList<>();
        forumThreads = forumThreadDAO.findByCategory("NEWS");

        logger.info("Forum Threads: -> {}", forumThreads.toString());
    }

    /**
     * Test of findByUsername method, of class ForumThreadDAOImpl.
     */
    @Test
    public void testFindByUsername() {

    }

    /**
     * Test of create method, of class ForumThreadDAOImpl.
     */
    @Test
    public void testCreate() {

    }

    /**
     * Test of update method, of class ForumThreadDAOImpl.
     */
    @Test
    public void testUpdate() {

    }

}
