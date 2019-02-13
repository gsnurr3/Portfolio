/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.controller;

import com.judgment.model.UserModel;
import com.judgment.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gsnurr3
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String SIGN_UP_URL = "/signup";
    private static final String CREATE_URL = "/create";
    private static final String CONTENT = "content";
    private static final String CONTENT_SIGN_UP = "content/signup";
    private static final String CONTENT_SUCCESS = "content/success";
    private static final String REDIRECT_ERROR = "redirect:/error";
    private static final String INDEX = "index";

    @Autowired
    private UserService userService;

    @GetMapping(SIGN_UP_URL)
    public String goToSignUpPage(Model model) {

        model.addAttribute("userModel", new UserModel());
        model.addAttribute(CONTENT, CONTENT_SIGN_UP);

        return INDEX;
    }

    @PostMapping(CREATE_URL)
    public String createGuest(Model model,
            @Valid @ModelAttribute("userModel") UserModel userModel,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute(CONTENT, CONTENT_SIGN_UP);

            return "index";
        }

        try {
            userService.createGuest(userModel);
        } catch (Exception e) {

            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                model.addAttribute("constraintException", "Username or email already exist. Please try another.");
                model.addAttribute(CONTENT, CONTENT_SIGN_UP);

                return INDEX;
            }

            return REDIRECT_ERROR;
        }

        model.addAttribute(CONTENT, CONTENT_SUCCESS);

        return INDEX;
    }
}
