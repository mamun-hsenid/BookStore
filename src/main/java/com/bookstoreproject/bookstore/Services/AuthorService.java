package com.bookstoreproject.bookstore.Services;

import com.bookstoreproject.bookstore.Entity.Author;

import java.util.List;

public interface AuthorService {
    int createAuthor(Author author);
    List<Author> getAllAuthors();

}
