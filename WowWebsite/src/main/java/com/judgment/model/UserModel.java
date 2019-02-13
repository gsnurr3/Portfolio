/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.model;

import com.judgment.validation.FieldMatch;
import com.judgment.validation.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gsnurr3
 */
@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields did not match. Please try again.")
})
public class UserModel {

    @NotNull(message = "Username is required.")
    @Size(min = 5, message = "Username must contain at least 5 characters.")
    private String username;

    @ValidEmail
    private String email;

    @NotNull(message = "Password is required.")
    @Size(min = 5, message = "Password must have at least 5 characters.")
    private String password;

    @NotNull(message = "Password is required again.")
    @Size(min = 5, message = "Password must have at least 5 characters.")
    private String matchingPassword;

    public UserModel() {
    }

    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        return "ForumUserModel{" + "username=" + username + ", email=" + email + ", password=" + password + ", matchingPassword=" + matchingPassword + '}';
    }
}
