/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.service;

import com.judgment.entity.ForumThread;
import java.util.List;

/**
 *
 * @author gsnurr3
 */
public interface ForumThreadService {

    List<ForumThread> findByCategory(String category);

    void create(ForumThread forumThread);
}
