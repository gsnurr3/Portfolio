/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumPost;

/**
 *
 * @author snurrg
 */
public interface ForumPostDAO {

    ForumPost findById(Long id);

    void create(ForumPost forumPost);

    void update(ForumPost forumPost);
}
