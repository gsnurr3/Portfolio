/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.User;

/**
 *
 * @author gsnurr3
 */
public interface UserDAO {

    User findByUsername(String username);

    User findByUsernameOrByEmail(String username, String email);

    User findByUsernameAndPassword(String username, String password);

    void create(User user);

    int updatePassword(User user, String password);
}
