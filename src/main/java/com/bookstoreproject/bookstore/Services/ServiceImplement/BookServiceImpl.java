package com.bookstoreproject.bookstore.Services.ServiceImplement;

import com.bookstoreproject.bookstore.Entity.Book;
import com.bookstoreproject.bookstore.Repository.BookRepository;
import com.bookstoreproject.bookstore.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public int createBook(Book book) {
        if (book != null) {
            return bookRepository.createBook(book);
        } else {
            return 0;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> book = bookRepository.getAllBooks();
        return book;
    }

    @Override
    public Book getBook(String name) {
        return null;
    }

    @Override
    public Book getBook(int id) {
        return null;
    }

    @Override
    public Book updateBookNameById(int id) {
        return null;
    }

    @Override
    public Book updateBookAuthorById(int id) {
        return null;
    }
}
