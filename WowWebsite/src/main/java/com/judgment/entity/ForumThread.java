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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author gsnurr3
 */
@Entity
@Table(name = "forum_thread")
public class ForumThread implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @UpdateTimestamp
    @Column(name = "lastUpdatedDate")
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "forum_thread_categories",
            joinColumns = @JoinColumn(name = "forum_thread_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_category_id"))
    private ForumCategory forumCategory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "forum_thread_posts",
            joinColumns = @JoinColumn(name = "forum_thread_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_post_id"))
    private Set<ForumPost> forumPosts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "forum_thread_votes",
            joinColumns = @JoinColumn(name = "forum_thread_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_vote_id"))
    private Set<ForumVote> forumVotes;

    public ForumThread() {
        this.forumPosts = new HashSet<>();
        this.forumVotes = new HashSet<>();
    }

    public ForumThread(String username, String title, String text, ForumCategory forumCategory) {
        this.forumPosts = new HashSet<>();
        this.forumVotes = new HashSet<>();
        this.username = username;
        this.title = title;
        this.text = text;
        this.forumCategory = forumCategory;
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

    public ForumCategory getForumCategory() {
        return forumCategory;
    }

    public void setForumCategory(ForumCategory forumCategory) {
        this.forumCategory = forumCategory;
    }

    public Set<ForumPost> getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(Set<ForumPost> forumPosts) {
        this.forumPosts = forumPosts;
    }

    public Set<ForumVote> getForumVotes() {
        return forumVotes;
    }

    public void setForumVotes(Set<ForumVote> forumVotes) {
        this.forumVotes = forumVotes;
    }

    @Override
    public String toString() {
        return "ForumThread{" + "id=" + id + ", username=" + username + ", title=" + title + ", text=" + text + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + ", forumCategory=" + forumCategory + ", forumPosts=" + forumPosts + ", forumVotes=" + forumVotes + '}';
    }
}
