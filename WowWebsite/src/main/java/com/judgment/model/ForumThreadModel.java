/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.model;

import java.time.LocalDateTime;

/**
 *
 * @author snurrg
 */
public class ForumThreadModel {

    private Long id;

    private String username;

    private String title;

    private String text;

    private LocalDateTime lastUpdatedDate;

    private LocalDateTime createdDate;

    private int numberOfReplies;

    private int totalVotes;

    public ForumThreadModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getNumberOfReplies() {
        return numberOfReplies;
    }

    public void setNumberOfReplies(int numberOfReplies) {
        this.numberOfReplies = numberOfReplies;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    @Override
    public String toString() {
        return "ForumThreadModel{" + "id=" + id + ", username=" + username + ", title=" + title + ", text=" + text + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + ", numberOfReplies=" + numberOfReplies + ", totalVotes=" + totalVotes + '}';
    }
}
