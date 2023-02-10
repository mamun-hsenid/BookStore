package com.bookstoreproject.bookstore.controller;

import com.bookstoreproject.bookstore.entity.Author;
import com.bookstoreproject.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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






    @GetMapping("/author/author-list")
    public String etAuthorList(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }


    @GetMapping("/author/addauthor")
    public String addUserForm(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "addAuthorForm";
    }

    @PostMapping("/author/add")
    public String createUser(@ModelAttribute("author") Author author) {
        System.out.println("add author"+author);
        try{
            authorService.createAuthor(author);
            return "redirect:/author/author-list";
        }catch(Exception e){
            return "redirect:/author/author-list";
        }
    }

    @GetMapping("/author/update")
    public String updateUserForm(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        System.out.println("inside update : "+author);
        return "updateAuthorForm";
    }

    @PostMapping("/author/update/authorname")
    public String updateBookName(@ModelAttribute("author") Author author) {
        System.out.println("update author"+author);
        try{
            authorService.updateAuthorNameById(author, author.getAuthorId());
            return "redirect:/author/author-list";
        }catch(Exception e){
            return "redirect:/author/author-list";
        }
    }

    @PostMapping("/author/update/authoremail")
    public String updateAuthorName(@ModelAttribute("author") Author author) {
        System.out.println("update book"+author);
        try{
            authorService.updateAuthorEmailById(author, author.getAuthorId());
            return "redirect:/author/author-list";
        }catch(Exception e){
            return "redirect:/author/author-list";
        }
    }

    @GetMapping("/author/delete/{authorId}")
    public String deleteUser(@PathVariable("authorId") int authorId){
        System.out.println("");
        System.out.println("delete author"+authorId);
        try{
            authorService.deleteAuthorById(authorId);
            return "redirect:/author/author-list";
        }catch(Exception e){
            return "redirect:/author/author-list";
        }
    }



















//    @GetMapping("/author/author-list")
//    public String getAuthorList(Model model) {
//        model.addAttribute("authors", bookService.getAllBooks());
//        return "authors";
//    }

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
