/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.controller;

import com.judgment.service.ForumThreadService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gsnurr3
 */
@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumThreadService forumThreadService;

    private static final String NEWS_FORUM_URL = "/news";
    private static final String GENERAL_FORUM_URL = "/general";
    private static final String GUILD_FORUM_URL = "/guild";
    private static final String CONTENT = "content";
    private static final String CONTENT_FORUM = "content/forum";
    private static final String FORUM_DATA = "forumThreads";
    private static final String FRAGMENTS_FORUM_LIST = "fragments/forum-list :: #forumData";
    private static final String INDEX = "index";
    private static final String NEWS = "NEWS";
    private static final String GENERAL = "GENERAL";
    private static final String GUILD = "GUILD";

    @GetMapping("")
    public String getForumPage(HttpServletRequest request, Model model) {

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

        model.addAttribute(CONTENT, CONTENT_FORUM);

        return INDEX;
    }

    @GetMapping(NEWS_FORUM_URL)
    public String getForumNews(Model model) {

        model.addAttribute(FORUM_DATA, forumThreadService.findByCategory(NEWS));

        return FRAGMENTS_FORUM_LIST;
    }

    @GetMapping(GENERAL_FORUM_URL)
    public String getForumGeneral(Model model) {

        model.addAttribute(FORUM_DATA, forumThreadService.findByCategory(GENERAL));

        return FRAGMENTS_FORUM_LIST;
    }

    @GetMapping(GUILD_FORUM_URL)
    public String getForumGuild(Model model) {

        model.addAttribute(FORUM_DATA, forumThreadService.findByCategory(GUILD));

        return FRAGMENTS_FORUM_LIST;
    }
}
