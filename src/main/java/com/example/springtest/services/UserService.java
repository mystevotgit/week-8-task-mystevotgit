package com.example.springtest.services;

import com.example.springtest.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void SaveUserData(User user);
    public List<User> FindUserData(String email);
}
