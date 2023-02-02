package com.bookstoreproject.bookstore.Services;

import com.bookstoreproject.bookstore.Entity.Book;
import com.bookstoreproject.bookstore.Entity.User;

import java.util.List;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBook(String name);

    Book getBook(int id);

    Book updateBookNameById(int id);
    Book updateBookAuthorById(int id);
}
