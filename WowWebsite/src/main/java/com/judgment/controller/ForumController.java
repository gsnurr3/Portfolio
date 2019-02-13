/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.controller;

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

    private static final String NEWS_FORUM_URL = "/news";
    private static final String GENERAL_FORUM_URL = "/general";
    private static final String GUILD_FORUM_URL = "/guild";
    private static final String CONTENT = "content";
    private static final String CONTENT_FORUM = "content/forum";
    private static final String INDEX = "index";

    @GetMapping(NEWS_FORUM_URL)
    public String getForumNews(Model model) {

        model.addAttribute(CONTENT, CONTENT_FORUM);

        return INDEX;
    }

    @GetMapping(GENERAL_FORUM_URL)
    public String getForumGeneral(Model model) {

        model.addAttribute(CONTENT, CONTENT_FORUM);

        return INDEX;
    }

    @GetMapping(GUILD_FORUM_URL)
    public String getForumGuild(Model model) {

        model.addAttribute(CONTENT, CONTENT_FORUM);

        return INDEX;
    }
}
