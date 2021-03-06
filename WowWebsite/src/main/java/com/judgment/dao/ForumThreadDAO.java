/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumThread;
import com.judgment.entity.User;
import java.util.List;

/**
 *
 * @author snurrg
 */
public interface ForumThreadDAO {

    ForumThread findById(Long id);

    List<ForumThread> findByCategory(String category);

    ForumThread findByUsername(User user);

    void create(ForumThread forumThread);

    void update(ForumThread forumThread);
}
