package com.example.springtest.controllers;

import com.example.springtest.models.Post;
import com.example.springtest.models.User;
import com.example.springtest.repository.PostRepository;
import com.example.springtest.services.PostService;
import com.example.springtest.services.UserService;
import com.example.springtest.servicesimpl.PostServiceImpl;
import com.example.springtest.servicesimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthGetController {


    @Autowired
    private PostService postService;
    @Autowired
    UserService userService;

    private Post post;
    private User user;
    private BindingResult result;
    private Model model;


    @Autowired
    public AuthGetController(UserServiceImpl userService) {
        this.userService = userService;
    }
    public AuthGetController(PostServiceImpl postService) {
        this.postService = postService;
    }

    /**
     * This method routes the user to the sign-up/login page
     * @param user
     * @param result
     * @param model
     * @return
     */
    @GetMapping("/")
    public String signUp_logIn(@Valid User user, BindingResult result, Model model) {
        return "index";
    }

    /**
     * This method fetches all the data meant to be on the posts page.
     * It then routes to the posts page.
     * @param session
     * @return
     */
    @GetMapping("/posts")
    public String userPosts(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        List<Post> postList = postService.FindAllPosts();
        model.addAttribute("posts", postList);
        System.out.println("Hi............");
        return "posts";
    }

    /**
     * This method logs a user out.
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
