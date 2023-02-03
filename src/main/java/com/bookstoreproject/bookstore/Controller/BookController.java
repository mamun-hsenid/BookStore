package com.bookstoreproject.bookstore.Controller;


import com.bookstoreproject.bookstore.Entity.Book;
import com.bookstoreproject.bookstore.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public int addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

}
