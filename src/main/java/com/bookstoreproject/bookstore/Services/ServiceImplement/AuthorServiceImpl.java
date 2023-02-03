package com.bookstoreproject.bookstore.Services.ServiceImplement;

import com.bookstoreproject.bookstore.Entity.Author;
import com.bookstoreproject.bookstore.Repository.AuthorRepository;
import com.bookstoreproject.bookstore.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public int createAuthor(Author author) {
        return authorRepository.createAuthor(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }
}
