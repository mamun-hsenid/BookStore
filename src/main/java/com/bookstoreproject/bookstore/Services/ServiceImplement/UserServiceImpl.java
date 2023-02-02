package com.bookstoreproject.bookstore.Services.ServiceImplement;

import com.bookstoreproject.bookstore.Entity.User;
import com.bookstoreproject.bookstore.Repository.UserRepository;
import com.bookstoreproject.bookstore.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public int createUser(User user) {
        if (user != null) {
            return userRepository.save(user);
        } else {
            return 0;
        }
    }

    @Override
    public List <User> getAllUsers() {
        List <User> users = userRepository.getAllUsers();
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = (User) userRepository.getSingleUser(id);
        return user;
    }

    @Override
    public int updateUserName(User user) {
        return userRepository.updateUserName(user);
    }

    @Override
    public int updateUserEmail(User user) {
        return userRepository.updateUserEmail(user);
    }

    @Override
    public int updateUserPassword(User user) {
        return userRepository.updateUserPassword(user);
    }

    @Override
    public int deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
}
