/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.ForumCategory;

/**
 *
 * @author snurrg
 */
public interface ForumCategoryDAO {

    ForumCategory findByName(String name);
}
