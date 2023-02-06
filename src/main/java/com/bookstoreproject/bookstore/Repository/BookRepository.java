package com.bookstoreproject.bookstore.Repository;

import com.bookstoreproject.bookstore.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@Configuration
@PropertySource("classpath:queries.properties")
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${book.create}")
    String createBook;
    @Value("${book.get-all}")
    String getAllBooks;
    @Value("${book.get-single}")
    String getSingleBook;
    @Value("${book.update-bookname}")
    String updateBookName;
    @Value("${book.update-bookauthor}")
    String updateBookAuthor;
    @Value("${book.delete}")
    String deleteBook;

    public int createBook(Book book) {
        return jdbcTemplate.update(createBook,book.getBookName(), book.getBookAuthor());
    }
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(
                getAllBooks,
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("book_id"),
                                rs.getString("book_name"),
                                rs.getString("book_author")
                        )
        );
    }
    public int updateBookName(Book book, int id) {
        return jdbcTemplate.update(updateBookName, book.getBookName(), id);
    }

    public int updateBookAuthor(Book book, int id) {
        return jdbcTemplate.update(updateBookAuthor, book.getBookAuthor(), id);
    }
    public int deleteBookById(int id) {
        return jdbcTemplate.update(deleteBook,id);
    }
}
