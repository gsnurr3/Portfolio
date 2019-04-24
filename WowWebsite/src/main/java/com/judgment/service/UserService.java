/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.service;

import com.judgment.entity.User;
import com.judgment.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author gsnurr3
 */
public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User findByUsernameOrByEmail(String username, String email);

    User findByUsernameAndPassword(String username, String password);

    User registerUserByUsernameAndRegistrationCode(String username, String registrationCode);

    void createGuest(UserModel userModel);

    void createClient(UserModel userModel);

    void createAdmin(UserModel userModel);

    void updatePassword(UserModel userModel, String password);
}
