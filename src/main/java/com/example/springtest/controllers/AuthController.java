package com.example.springtest.controllers;

import com.example.springtest.models.User;
import com.example.springtest.servicesimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;



@Controller
public class AuthController {
    UserServiceImpl userService = new UserServiceImpl();
    private User user;
    private BindingResult result;
    private Model model;

    @Autowired
    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }


    /**
     * This method handles the login request of users.
     * @param formData
     * @param user
     * @param result
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String userLogin(@RequestParam HashMap<String, String> formData, @Valid User user, BindingResult result, Model model, HttpSession session) {
        List<User> userData = userService.FindUserData(formData.get("email"));
        if (userData.size() != 0){
            if (userData.get(0).getPassword().equals(formData.get("password"))) {
                session.setAttribute("user", userData.get(0));
                return "redirect:/posts";
            }
        }
        return "index";
    }


    /**
     * This method handles the registration of users.
     * @param formData
     * @param user
     * @param result
     * @return
     */
    @PostMapping("/register")
    public String addUser(@RequestParam HashMap<String, String> formData, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        user = new User();
        user.setFirstname(formData.get("firstname"));
        user.setLastname(formData.get("lastname"));
        user.setEmail(formData.get("email"));
        user.setGender(formData.get("gender"));
        user.setDob(formData.get("dob"));
        user.setPassword(formData.get("password"));
        userService.SaveUserData(user);
        return "redirect:/";
    }
}
