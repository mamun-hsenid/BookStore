package com.bookstoreproject.bookstore.Repository;

import com.bookstoreproject.bookstore.Entity.User;
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
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${user.create}")
    String createUser;

    @Value("${user.get-all}")
    String getAllUsers;

    @Value("${user.get-single}")
    String getSingleUser;

    @Value("${user.update-username}")
    String updateUserName;

    @Value("${user.update-useremail}")
    String updateUserEmail;

    @Value("${user.update-userpassword}")
    String updateUserPassword;

    @Value("${user.delete}")
    String deleteUser;

    public int save(User user) {
        return jdbcTemplate.update(createUser, user.getUserName(), user.getUserEmail(), user.getUserPassword());
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query(
            getAllUsers,
            (rs, rowNum) ->
                new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_password")
                )
        );
    }

    public Object getSingleUser(int userId) {
        return jdbcTemplate.queryForObject(
            getSingleUser,
            (rs, rowNum) ->
                new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_password"
                )
            )
        );
    }

    public int updateUserName(User user) {
        return jdbcTemplate.update(updateUserName, user.getUserName());
    }

    public int updateUserPassword(User user) {
        return jdbcTemplate.update(updateUserPassword, user.getUserPassword());
    }

    public int updateUserEmail(User user) {
        return jdbcTemplate.update(updateUserEmail, user.getUserEmail());
    }

    public int deleteUser(int id) {
        return jdbcTemplate.update(deleteUser, id);
    }
}
