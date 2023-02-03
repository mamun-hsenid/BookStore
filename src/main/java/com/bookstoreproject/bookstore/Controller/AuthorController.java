package com.bookstoreproject.bookstore.Controller;

import com.bookstoreproject.bookstore.Entity.Author;
import com.bookstoreproject.bookstore.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    @ResponseBody
    public int addAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
    @GetMapping("/get-author")
    @ResponseBody
    public List<Author> getAuthor(){
        return authorService.getAllAuthors();
    }
}
