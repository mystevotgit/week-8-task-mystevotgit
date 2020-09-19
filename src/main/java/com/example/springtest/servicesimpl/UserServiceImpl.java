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

    /**
     * This implementation method saves a user in the database
     * @param user
     */
    @Override
    public void SaveUserData(User user) {
        userRepository.save(user);
    }

    /**
     * This implementation method fetches a user from the database
     * @param email
     * @return
     */
    @Override
    public List<User> FindUserData(String email) {
        return userRepository.findByEmail(email);
    }


}
