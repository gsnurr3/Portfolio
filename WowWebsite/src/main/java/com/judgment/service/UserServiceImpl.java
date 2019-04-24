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
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.DisabledException;
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

    private static final String SUBJECT = "WoW Website Registration";

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthorityDAO authorityDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

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
    public User registerUserByUsernameAndRegistrationCode(String username, String registrationCode) {

        User user = userDAO.findByUsername(username);

        if (user == null || user.getRegistrationCode() == null || !user.getRegistrationCode().equals(registrationCode)) {
            return null;
        }

        if (registrationCode.equals(user.getRegistrationCode())) {
            user.setEnabled(true);
            user.setRegistrationCode(null);
            userDAO.updateEnabledAndRegistrationCode(user);
        }

        return user;
    }

    @Override
    @Transactional
    public void createGuest(UserModel userModel) {

        User user = this.createUser(userModel, GUEST);

        userDAO.create(user);

        this.sendRegistrationEmail(user.getEmail(), user.getUsername(), user.getRegistrationCode());
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

        if (user.isEnabled() == false) {
            throw new DisabledException("This account's email has not been verified.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
    }

    private User createUser(UserModel userModel, String authorityType) {

        User user = new User();

        user.setUsername(userModel.getUsername().toLowerCase());
        user.setEmail(userModel.getEmail().toLowerCase());
        user.setPassword(userModel.getPassword());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(false);
        user.setAuthorities(Arrays.asList(authorityDAO.findByName(authorityType)));
        user.setRegistrationCode(UUID.randomUUID().toString());

        return user;
    }

    private void sendRegistrationEmail(String email, String username, String registrationCode) {

        StringBuilder text = new StringBuilder();

        text.append("Welcome to the Wow Community Website ")
                .append(username)
                .append(". Please click the following URL to reigister your email: http://localhost:8080/user/registration?username=")
                .append(username)
                .append("&registrationCode=")
                .append(registrationCode);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(SUBJECT);
        simpleMailMessage.setText(text.toString());

        mailSender.send(simpleMailMessage);
    }
}
