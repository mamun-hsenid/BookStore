package com.bookstoreproject.bookstore.controller;

import com.bookstoreproject.bookstore.entity.User;
import com.bookstoreproject.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "addUserForm";
    }

    @GetMapping("/update")
    public String updateUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        System.out.println("inside update : "+user);
        return "updateUserForm";
    }

    @GetMapping("/user-list")
    public String getUserList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user){
        System.out.println("add user"+user);
        try{
            userService.createUser(user);
            return "redirect:/user/user-list";
        }catch(Exception e){
            return "redirect:/user/user-list";
        }
    }

    @PostMapping("/update/username")
    public String updateUserName(@ModelAttribute("user") User user){
        System.out.println("");
        System.out.println("update user"+user);
        try{
            userService.updateUserName(user,user.getUserId());
            return "redirect:/user/user-list";
        }catch(Exception e){
            return "redirect:/user/user-list";
        }
    }


    @PostMapping("/update/userpassword")
    public String updateUserPassword(@ModelAttribute("user") User user){
        System.out.println("");
        System.out.println("update user"+user);
        try{
            userService.updateUserPassword(user,user.getUserId());
            return "redirect:/user/user-list";
        }catch(Exception e){
            return "redirect:/user/user-list";
        }
    }

    @PostMapping("/update/email")
    public String updateUserEmail(@ModelAttribute("user") User user){
        System.out.println("");
        System.out.println("update user"+user);
        try{
            userService.updateUserEmail(user,user.getUserId());
            return "redirect:/user/user-list";
        }catch(Exception e){
            return "redirect:/user/user-list";
        }
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        System.out.println("");
        System.out.println("delete user"+userId);
        try{
            userService.deleteUser(userId);
            return "redirect:/user/user-list";
        }catch(Exception e){
            return "redirect:/user/user-list";
        }
    }

//    @PostMapping
//    public ResponseEntity<Object> addUser(@RequestBody User user){
//        System.out.println("add user"+user);
//        try{
//            userService.createUser(user);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }catch(Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

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

