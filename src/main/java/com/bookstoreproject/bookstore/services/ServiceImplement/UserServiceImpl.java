package com.bookstoreproject.bookstore.services.ServiceImplement;

import com.bookstoreproject.bookstore.entity.User;
import com.bookstoreproject.bookstore.repository.UserRepository;
import com.bookstoreproject.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public int createUser(User user) {
        if (user != null) {
            return userRepository.createUserve(user);
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
    public int updateUserName (User user, int id){
        return userRepository.updateUserName(user, id);
    }
    @Override
    public int updateUserEmail (User user, int id) {
        return userRepository.updateUserEmail(user, id);
    }
    @Override
    public int updateUserPassword(User user, int id) {
        return userRepository.updateUserPassword(user, id);
    }
    @Override
    public int deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
}
