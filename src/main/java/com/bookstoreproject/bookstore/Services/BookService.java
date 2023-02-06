package com.bookstoreproject.bookstore.Services;

import com.bookstoreproject.bookstore.Entity.Book;

import java.util.List;

public interface BookService {

    int createBook(Book book);
    List<Book> getAllBooks();
    int updateBookNameById(Book book, int id);
    int updateBookAuthorById(Book book, int id);

    int deleteBookById(int id);
}
