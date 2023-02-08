package com.bookstoreproject.bookstore.services;
import com.bookstoreproject.bookstore.entity.Author;
import java.util.List;

public interface AuthorService {
    int createAuthor(Author author);
    List<Author> getAllAuthors();
    int updateAuthorNameById(Author author, int id);
    int updateAuthorEmailById(Author author, int id);

    int deleteAuthorById(int id);

}

