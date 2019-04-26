package com.judgment.SpringBackend;

import com.judgment.dao.ForumCategoryDAO;
import com.judgment.dao.ForumPostDAO;
import com.judgment.dao.ForumThreadDAO;
import com.judgment.entity.ForumPost;
import com.judgment.entity.ForumThread;
import com.judgment.entity.ForumVote;
import com.judgment.entity.User;
import com.judgment.model.UserModel;
import com.judgment.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = "com.judgment")
@EntityScan(basePackages = "com.judgment.entity")
public class SpringBackendApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ForumThreadDAO forumThreadDAO;

    @Autowired
    private ForumPostDAO forumPostDAO;

    @Autowired
    private ForumCategoryDAO forumCategoryDAO;

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // CREATE USER
        UserModel userModel = new UserModel("guest", "guest@hotmail.com", "mortmort");
        userService.createGuest(userModel);

        userModel = new UserModel("client", "client@hotmail.com", "mortmort");
        userService.createClient(userModel);

        userModel = new UserModel("admin", "admin@hotmail.com", "mortmort");
        userService.createAdmin(userModel);

        User user1 = userService.findByUsername("guest");
        User user2 = userService.findByUsername("client");
        User user3 = userService.findByUsername("admin");

        // CREATE FORUM THREAD
        ForumThread forumThread = new ForumThread(user1.getUsername(), "This is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sdad title", "This is the thread text", forumCategoryDAO.findByName("GUILD"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user2.getUsername(), "This is the thread title", "This This is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad titleis the thread text", forumCategoryDAO.findByName("GENERAL"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user1.getUsername(), "This is the thread title", "This is the thread text", forumCategoryDAO.findByName("GENERAL"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user3.getUsername(), "This is theThis is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad title thread title", "This is the thread text", forumCategoryDAO.findByName("GENERAL"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user3.getUsername(), "This is the thread title", "This is the thread text", forumCategoryDAO.findByName("NEWS"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user3.getUsername(), "This is the thrThis is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad titleead title", "This is thThis is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad titlee thread text", forumCategoryDAO.findByName("NEWS"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user1.getUsername(), "This is the thread title", "This is the thread text", forumCategoryDAO.findByName("NEWS"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user3.getUsername(), "This is the This is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad titlethread title", "This is the thread text", forumCategoryDAO.findByName("NEWS"));
        forumThreadDAO.create(forumThread);

        forumThread = new ForumThread(user2.getUsername(), "This is the thread title", "This is the thread text", forumCategoryDAO.findByName("NEWS"));
        forumThreadDAO.create(forumThread);

        // CREATE FORUM POST
        ForumPost forumPost = new ForumPost(user3.getUsername(), "This is the post text.");
        forumThread = forumThreadDAO.findById(1L);
        forumThread.getForumPosts().add(forumPost);
        forumThreadDAO.update(forumThread);

        forumPost = new ForumPost(user3.getUsername(), "This is the This is the thre dsfdsf dsfds fdsf dsfds dsf dsf dsfds sdfsd fdsf dsf sdfsd fsdf sdfds fsd fsdf dsf sdf dsf sdf dsf sd fsd fsdf sd fds fsf sdad titlepost text.");
        forumThread = forumThreadDAO.findById(1L);
        forumThread.getForumPosts().add(forumPost);
        forumThreadDAO.update(forumThread);

        forumPost = new ForumPost(user2.getUsername(), "This is the post text.");
        forumThread = forumThreadDAO.findById(2L);
        forumThread.getForumPosts().add(forumPost);
        forumThreadDAO.update(forumThread);

        forumPost = new ForumPost(user1.getUsername(), "This is the post text.");
        forumThread = forumThreadDAO.findById(3L);
        forumThread.getForumPosts().add(forumPost);
        forumThreadDAO.update(forumThread);

        //CREATE THREAD VOTE
        ForumVote forumVote = new ForumVote(user1.getUsername(), 1);
        forumThread = forumThreadDAO.findById(3L);
        forumThread.getForumVotes().add(forumVote);
        forumThreadDAO.update(forumThread);

        forumVote = new ForumVote(user1.getUsername(), 1);
        forumThread = forumThreadDAO.findById(3L);
        forumThread.getForumVotes().add(forumVote);
        forumThreadDAO.update(forumThread);

        forumVote = new ForumVote(user2.getUsername(), -1);
        forumThread = forumThreadDAO.findById(2L);
        forumThread.getForumVotes().add(forumVote);
        forumThreadDAO.update(forumThread);

        forumVote = new ForumVote(user3.getUsername(), 1);
        forumThread = forumThreadDAO.findById(1L);
        forumThread.getForumVotes().add(forumVote);
        forumThreadDAO.update(forumThread);

        // CREATE POST VOTE
        forumVote = new ForumVote(user3.getUsername(), -1);
        forumPost = forumPostDAO.findById(1L);
        forumPost.getForumVotes().add(forumVote);
        forumPostDAO.update(forumPost);

        forumVote = new ForumVote(user2.getUsername(), -1);
        forumPost = forumPostDAO.findById(2L);
        forumPost.getForumVotes().add(forumVote);
        forumPostDAO.update(forumPost);

        forumVote = new ForumVote(user1.getUsername(), 0);
        forumPost = forumPostDAO.findById(2L);
        forumPost.getForumVotes().add(forumVote);
        forumPostDAO.update(forumPost);

        forumVote = new ForumVote(user2.getUsername(), 1);
        forumPost = forumPostDAO.findById(3L);
        forumPost.getForumVotes().add(forumVote);
        forumPostDAO.update(forumPost);
    }
}
