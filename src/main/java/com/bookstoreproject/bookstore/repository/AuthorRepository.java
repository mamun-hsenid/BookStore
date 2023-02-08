package com.bookstoreproject.bookstore.repository;

import com.bookstoreproject.bookstore.entity.Author;
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

    public int createAuthor(Author author) {
        if (author != null){
            return jdbcTemplate.update(createAuthor, author.getAuthorName(), author.getAuthorEmail());
        } else{
            return 0;
        }
    }
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(
            getAllAuthors,
            (rs, rowNum) ->
                new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name"),
                        rs.getString("author_email")
                )
        );
    }
    public int updateAuthorName(Author author, int id){
        System.out.println("Author in update: " + author + " id :" +id);
        return jdbcTemplate.update(updateAuthorName, author.getAuthorName(), id);
    }
    public int updateAuthorEmail(Author author, int id){
        return jdbcTemplate.update(updateAuthorEmail, author.getAuthorEmail(), id);
    }
    public int deleteAuthor(int id){
        return jdbcTemplate.update(deleteAuthor, id);
    }

}
