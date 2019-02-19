/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.service;

import com.judgment.dao.ForumThreadDAO;
import com.judgment.entity.ForumThread;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gsnurr3
 */
@Service
public class ForumThreadServiceImpl implements ForumThreadService {

    @Autowired
    private ForumThreadDAO forumThreadDAO;

    @Override
    public List<ForumThread> findByCategory(String category) {

        return forumThreadDAO.findByCategory(category);
    }

    @Override
    public void create(ForumThread forumThread) {

        forumThreadDAO.create(forumThread);
    }
}
