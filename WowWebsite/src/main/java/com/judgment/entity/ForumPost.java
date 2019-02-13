/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author gsnurr3
 */
@Entity
@Table(name = "forum_post")
public class ForumPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "text", nullable = false)
    private String text;

    @UpdateTimestamp
    @Column(name = "lastUpdatedDate", nullable = false)
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "forum_post_votes",
            joinColumns = @JoinColumn(name = "forum_post_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_vote_id"))
    private Set<ForumVote> forumVotes;

    public ForumPost() {
        this.forumVotes = new HashSet<>();
    }

    public ForumPost(String username, String text) {
        this.forumVotes = new HashSet<>();
        this.username = username;
        this.text = text;
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

    public Set<ForumVote> getForumVotes() {
        return forumVotes;
    }

    public void setForumVotes(Set<ForumVote> forumVotes) {
        this.forumVotes = forumVotes;
    }

    @Override
    public String toString() {
        return "ForumPost{" + "id=" + id + ", username=" + username + ", text=" + text + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + ", forumVotes=" + forumVotes + '}';
    }
}
