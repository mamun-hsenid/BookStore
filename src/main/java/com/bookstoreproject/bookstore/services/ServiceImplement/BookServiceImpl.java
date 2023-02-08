package com.bookstoreproject.bookstore.services.ServiceImplement;

import com.bookstoreproject.bookstore.entity.AuthorBook;
import com.bookstoreproject.bookstore.entity.Book;
import com.bookstoreproject.bookstore.repository.BookRepository;
import com.bookstoreproject.bookstore.services.BookService;
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
    public List<AuthorBook> getBookAuthor(String name) {
        return bookRepository.getBookAuthor(name);
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
