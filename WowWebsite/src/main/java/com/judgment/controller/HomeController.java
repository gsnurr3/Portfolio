/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author gsnurr3
 */
@Controller
public class HomeController {

    private static final String HOME_URL = "/home";
    private static final String CONTENT = "content";
    private static final String CONTENT_HOME = "content/home";
    private static final String INDEX = "index";

    @GetMapping(HOME_URL)
    public String goToHomePage(HttpServletRequest request, Model model) {

        if (request.getSession().getAttribute("logoutSuccessful") != null) {
            model.addAttribute("logoutSuccessful", "true");
            request.getSession().removeAttribute("logoutSuccessful");
        }

        if (request.getSession().getAttribute("loginError") != null) {
            if (request.getSession().getAttribute("loginError").equals("This account's email has not been verified.")) {
                model.addAttribute("loginError", "This account's email has not been verified.");
            }

            if (request.getSession().getAttribute("loginError").equals("Invalid username or password.")) {
                model.addAttribute("loginError", "Invalid username or password.");
            }

            request.getSession().removeAttribute("loginError");
        }

        model.addAttribute(CONTENT, CONTENT_HOME);

        return INDEX;
    }
}
