package com.example.springtest.servicesimpl;

import com.example.springtest.models.User;
import com.example.springtest.repository.UserRepository;
import com.example.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void SaveUserData(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> FindUserData(String email) {
        return userRepository.findByEmail(email);
    }


}
