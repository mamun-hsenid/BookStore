package com.bookstoreproject.bookstore.Services;

import com.bookstoreproject.bookstore.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
   int createUser (User user);
   List<User> getAllUsers ();
   User getUserById (int id);
   int updateUserName (User user);
   int updateUserEmail (User user);


   int updateUserPassword (User user);
   int deleteUser (int id);

}
