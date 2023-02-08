package com.bookstoreproject.bookstore.controller;

import com.bookstoreproject.bookstore.entity.Author;
import com.bookstoreproject.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    @ResponseBody
    public int addAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
    @GetMapping("/author")
    @ResponseBody
    public List<Author> getAuthor(){
        return authorService.getAllAuthors();
    }

    @DeleteMapping("/author/{id}")
    @ResponseBody
    public int deleteAuthor(@PathVariable("id") int id){
        return authorService.deleteAuthorById(id);
    }

    @PutMapping("/author/update-name/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateAuthorName(@RequestBody Author author, @PathVariable("id") Integer id){
        System.out.println("Author from controller "+author);
        System.out.println("id "+id);
        try{
            authorService.updateAuthorNameById(author, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/author/update-email/{id}")
    @ResponseBody
    public int updateAuthorEmail(@RequestBody Author author, @PathVariable("id") int id){
        return  authorService.updateAuthorEmailById(author, id);
    }
}
