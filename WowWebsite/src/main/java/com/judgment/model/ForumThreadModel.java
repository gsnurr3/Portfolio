/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author snurrg
 */
public class ForumThreadModel {

    private UserModel userModel;

    private String title;

    private String text;

    private Date lastUpdatedDate;

    private Date createdDate;

    private List<ForumPostModel> forumPostModels;

    private List<ForumVoteModel> forumVoteModels;

    public ForumThreadModel() {
    }

    public ForumThreadModel(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<ForumPostModel> getForumPostModels() {
        return forumPostModels;
    }

    public void addForumPostModel(ForumPostModel forumPostModel) {
        this.forumPostModels.add(forumPostModel);
    }

    public void removeForumPostModel(ForumPostModel forumPostModel) {
        this.forumPostModels.remove(forumPostModel);
    }

    public List<ForumVoteModel> getForumVoteModels() {
        return forumVoteModels;
    }

    public void addForumVoteModel(ForumVoteModel forumVoteModel) {
        this.forumVoteModels.add(forumVoteModel);
    }

    public void removeForumVoteModel(ForumVoteModel forumVoteModel) {
        this.forumVoteModels.remove(forumVoteModel);
    }

    @Override
    public String toString() {
        return "ForumThreadModel{" + "userModel=" + userModel + ", title=" + title + ", text=" + text + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + ", forumPostModels=" + forumPostModels + ", forumVoteModels=" + forumVoteModels + '}';
    }
}
