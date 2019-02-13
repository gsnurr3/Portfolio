/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumVote;

/**
 *
 * @author snurrg
 */
public interface ForumVoteDAO {

    ForumVote findById(Long id);

    void create(ForumVote forumVote);
}
