package com.bookstoreproject.bookstore.services;

import com.bookstoreproject.bookstore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
   int createUser (User user);
   List<User> getAllUsers ();
   int updateUserName (User user, int id);
   int updateUserEmail (User user, int id);
   int updateUserPassword (User user, int id);
   int deleteUser(int id);

}
