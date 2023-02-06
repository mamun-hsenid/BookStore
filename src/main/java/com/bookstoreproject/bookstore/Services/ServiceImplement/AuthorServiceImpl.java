package com.bookstoreproject.bookstore.Services.ServiceImplement;

import com.bookstoreproject.bookstore.Entity.Author;
import com.bookstoreproject.bookstore.Entity.User;
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

    @Override
    public int updateAuthorNameById(Author author, int id) {
        System.out.println("Author in update: " + author + " id :" +id);
        return authorRepository.updateAuthorName(author, id);
    }
    @Override
    public int updateAuthorEmailById(Author author, int id) {
        return authorRepository.updateAuthorEmail(author, id);
    }

    @Override
    public int deleteAuthorById(int id) {
        return authorRepository.deleteAuthor(id);
    }
}
