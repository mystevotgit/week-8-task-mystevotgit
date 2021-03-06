package com.example.springtest.controllers;

import com.example.springtest.models.Post;
import com.example.springtest.models.User;
import com.example.springtest.services.PostService;
import com.example.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    private Post post;
    private User user;
    private BindingResult result;


    /**
     * This method can be used to create a post
     * @param formData
     * @param post
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/Create_post")
    public String createPost(@RequestParam HashMap<String, String> formData, @Valid Post post, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "posts";
        }
        post = new Post();
        user = (User) session.getAttribute("user");
        post.setUser_id(user.getId());
        post.setPost_date();
        post.setPost_text(formData.get("text"));
        postService.SavePostData(post);
        return "redirect:/posts";
    }

    /**
     * This method can be used to delete a post
     * @param formData
     * @param post
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/Delete_post")
    public String deletePost(@RequestParam HashMap<String, String> formData, @Valid Post post, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "posts";
        }
        Long id = Long.valueOf(formData.get("delete"));
        postService.DeletePostData(id);
        return "redirect:/posts";
    }

    /**
     * This method can be used to update a post
     * @param formData
     * @param post
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/Update_post")
    public String updatePost(@RequestParam HashMap<String, String> formData, @Valid Post post, BindingResult result, HttpSession session) {
        System.out.println("Helloo from controller ");
        if (result.hasErrors()) {
            return "posts";
        }
        Long id = Long.valueOf(formData.get("update"));
        Optional<Post> currentPost = postService.FindPostData(id);
        post.setId(id);
        post.setUser_id(currentPost.get().getUser_id());
        post.setPost_date();
        post.setPost_text(formData.get("text"));
        postService.UpdatePostData(post);
        return "redirect:/posts";
    }

    /**
     * This method can be used to like a post
     * @param formData
     * @param post
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/Like_post")
    public String likePost(@RequestParam HashMap<String, String> formData, @Valid Post post, BindingResult result, HttpSession session) {
        System.out.println("like");
        if (result.hasErrors()) {
            return "posts";
        }
        Long id = Long.valueOf(formData.get("like"));
        return "redirect:/posts";
    }

    /**
     * This method can be used to dislike a post
     * @param formData
     * @param post
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/Dislike_post")
    public String dislikePost(@RequestParam HashMap<String, String> formData, @Valid Post post, BindingResult result, HttpSession session) {
        System.out.println("Dislike");
        if (result.hasErrors()) {
            return "posts";
        }
        Long id = Long.valueOf(formData.get("like"));
        return "redirect:/posts";
    }
}
