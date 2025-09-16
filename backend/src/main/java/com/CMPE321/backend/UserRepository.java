package com.CMPE321.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> getUser(String username){
        try {
            User user = jdbcTemplate.queryForObject(
                    "SELECT username,password,name,surname,nationality FROM user WHERE username = ?",
                    (rs, rowNum) -> new User(
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("nationality")
                    ),
                    username
            );
            return user != null ? Optional.of(user) : Optional.empty();
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public boolean save(User user){
        int rowsAffected = jdbcTemplate.update("INSERT INTO " +
                "user(username,password,name,surname,nationality) " +
                "VALUES (?,?,?,?,?)",
                user.getUsername(),
                user.getPasswordHash(),
                user.getName(),
                user.getSurname(),
                user.getNationality());
        return rowsAffected > 0;
    }
}
