/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.service;

import com.judgment.dao.AuthorityDAO;
import com.judgment.dao.UserDAO;
import com.judgment.entity.Authority;
import com.judgment.entity.User;
import com.judgment.model.UserModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author gsnurr3
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String GUEST = "GUEST";
    private static final String CLIENT = "CLIENT";
    private static final String ADMIN = "ADMIN";

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthorityDAO authorityDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public User findByUsernameOrByEmail(String username, String email) {
        return userDAO.findByUsernameOrByEmail(username, email);
    }

    @Override
    @Transactional
    public User findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional
    public void createGuest(UserModel userModel) {

        User user = new User();

        user.setUsername(userModel.getUsername().toLowerCase());
        user.setEmail(userModel.getEmail().toLowerCase());
        user.setPassword(userModel.getPassword());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(Arrays.asList(authorityDAO.findByName(GUEST)));

        userDAO.create(user);
    }

    @Override
    @Transactional
    public void createClient(UserModel userModel) {

        User user = new User();

        user.setUsername(userModel.getUsername().toLowerCase());
        user.setEmail(userModel.getEmail().toLowerCase());
        user.setPassword(userModel.getPassword());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(Arrays.asList(authorityDAO.findByName(CLIENT)));

        userDAO.create(user);
    }

    @Override
    @Transactional
    public void createAdmin(UserModel userModel) {

        User user = new User();

        user.setUsername(userModel.getUsername().toLowerCase());
        user.setEmail(userModel.getEmail().toLowerCase());
        user.setPassword(userModel.getPassword());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(Arrays.asList(authorityDAO.findByName(ADMIN)));

        userDAO.create(user);
    }

    @Override
    public void updatePassword(UserModel userModel, String password) {

        User user = userDAO.findByUsername(userModel.getUsername());

        int isUpdateSuccessful = 0;

        if (user != null && passwordEncoder.matches(userModel.getPassword(), user.getPassword())) {
            isUpdateSuccessful = userDAO.updatePassword(user, passwordEncoder.encode(password));
        }

        if (isUpdateSuccessful == 1) {
            logger.info("Update password successful!");
        } else {
            logger.info("Update password not successful!");
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
    }
}
