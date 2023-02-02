package com.bookstoreproject.bookstore.Repository;

import com.bookstoreproject.bookstore.Entity.Author;
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
public class AuthorRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${author.create}")
    String createAuthor;

    @Value("${author.get-all}")
    String getAllAuthors;

    @Value("${author.get-single}")
    String getSingleAuthor;

    @Value("${author.update-authorname}")
    String updateAuthorName;

    @Value("${author.update-authoremail}")
    String updateAuthorEmail;

    @Value("${author.delete}")
    String deleteAuthor;
}
