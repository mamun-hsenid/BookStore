package com.bookstoreproject.bookstore.controller;


import com.bookstoreproject.bookstore.entity.AuthorBook;
import com.bookstoreproject.bookstore.entity.Book;
import com.bookstoreproject.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public int addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/update-name/{id}")
    public ResponseEntity<Object> updateBookName(@RequestBody Book book, @PathVariable("id") Integer id){
        System.out.println("Book from controller"+book);
        System.out.println("id "+id);
        try{
            bookService.updateBookNameById(book,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/update-author/{id}")
    public ResponseEntity<Object> updateBookAuthor(@RequestBody Book book, @PathVariable("id") Integer id){
        System.out.println("Book from controller "+book);
        System.out.println("id "+id);
        try{
            bookService.updateBookAuthorById(book,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") Integer id) {
        System.out.println("delete user" + id);
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/{name}")
    public List<AuthorBook> getAuthorBooks(@PathVariable("name") String name) {
        return bookService.getBookAuthor(name);
    }

}
