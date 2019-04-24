/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author gsnurr3
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ae) throws IOException, ServletException {

        try {
            if (ae.getCause().getMessage().equals("This account's email has not been verified.")) {
                request.getSession().setAttribute("loginError", "This account's email has not been verified.");
            }
        } catch (java.lang.NullPointerException e) {
            request.getSession().setAttribute("loginError", "Invalid username or password.");
        }

        response.sendRedirect("/home");
    }
}
