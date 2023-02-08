package com.bookstoreproject.bookstore.services;

import com.bookstoreproject.bookstore.entity.AuthorBook;
import com.bookstoreproject.bookstore.entity.Book;

import java.util.List;

public interface BookService {

    int createBook(Book book);
    List<Book> getAllBooks();
    List<AuthorBook> getBookAuthor(String name);
    int updateBookNameById(Book book, int id);
    int updateBookAuthorById(Book book, int id);

    int deleteBookById(int id);
}
