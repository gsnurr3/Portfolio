/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.model;

/**
 *
 * @author snurrg
 */
public class ForumVoteModel {

    private int upCount;

    private int downCount;

    private UserModel userModel;

    public ForumVoteModel() {
    }

    public ForumVoteModel(int upCount, int downCount) {
        this.upCount = upCount;
        this.downCount = downCount;
    }

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "ForumVoteModel{" + "upCount=" + upCount + ", downCount=" + downCount + ", userModel=" + userModel + '}';
    }
}
