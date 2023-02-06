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
    public int updateBookNameById(Book book, int id) {
        return bookRepository.updateBookName(book, id);
    }
    @Override
    public int updateBookAuthorById(Book book, int id) {
        return bookRepository.updateBookAuthor(book, id);
    }
    public int deleteBookById(int id){
        return bookRepository.deleteBookById(id);
    }
}
