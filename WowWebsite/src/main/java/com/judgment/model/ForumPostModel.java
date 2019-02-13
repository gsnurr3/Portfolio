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
public class ForumPostModel {

    private UserModel userModel;

    private String text;

    private Date lastUpdatedDate;

    private Date createdDate;

    private List<ForumVoteModel> forumVoteModels;

    public ForumPostModel() {
    }

    public ForumPostModel(String text) {
        this.text = text;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
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
        return "ForumPostModel{" + "userModel=" + userModel + ", text=" + text + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + ", forumVoteModels=" + forumVoteModels + '}';
    }
}
