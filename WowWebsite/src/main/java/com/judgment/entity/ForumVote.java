/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gsnurr3
 */
@Entity
@Table(name = "forum_vote")
public class ForumVote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "upCount", nullable = false)
    private int upCount;

    @Column(name = "downCount", nullable = false)
    private int downCount;

    public ForumVote() {
    }

    public ForumVote(String username, int upCount, int downCount) {
        this.username = username;
        this.upCount = upCount;
        this.downCount = downCount;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "ForumVote{" + "id=" + id + ", username=" + username + ", upCount=" + upCount + ", downCount=" + downCount + '}';
    }
}
