package com.bookstoreproject.bookstore.Repository;

import com.bookstoreproject.bookstore.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
