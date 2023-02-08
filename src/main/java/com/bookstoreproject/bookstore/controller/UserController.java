package com.bookstoreproject.bookstore.controller;

import com.bookstoreproject.bookstore.entity.User;
import com.bookstoreproject.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user){
        System.out.println("add user"+user);
        try{
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update-name/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        System.out.println("update user"+user);
        System.out.println("id "+id);
        try{
            userService.updateUserName(user,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/update-email/{id}")
    public ResponseEntity<Object> updateUserEmail(@RequestBody User user, @PathVariable("id") Integer id){
        System.out.println("update user"+user);
        System.out.println("id "+id);
        try{
            userService.updateUserEmail(user,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update-password/{id}")
    public ResponseEntity<Object> updateUserPassword(@RequestBody User user, @PathVariable("id") Integer id){
        System.out.println("update user"+user);
        System.out.println("id "+id);
        try{
            userService.updateUserPassword(user,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer id) {
        System.out.println("delete user" + id);
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

