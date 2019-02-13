/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author gsnurr3
 */
@Controller
public class IndexController implements ErrorController {

    private static final String INDEX1_URL = "";
    private static final String INDEX2_URL = "/";
    private static final String REDIRECT_HOME = "redirect:/home";
    private static final String CONTENT = "content";
    private static final String ERROR_ERROR = "error/error";
    private static final String INDEX = "index";
    private static final String PATH = "/error";

    @GetMapping(value = {INDEX1_URL, INDEX2_URL})
    public String goToIndex() {

        return REDIRECT_HOME;
    }

    @GetMapping(value = PATH)
    public String error(Model model) {

        model.addAttribute(CONTENT, ERROR_ERROR);

        return INDEX;
    }

    @Override
    public String getErrorPath() {

        return PATH;
    }
}
