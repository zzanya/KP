package com.example.KP_3;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    //public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        //this.jdbcTemplate = jdbcTemplate;
    //}

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO Users (name, email, phoneNumber) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User getUserById(Long userId) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserMapper());
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE Users SET name = ?, email = ?, phoneNumber = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhoneNumber(), user.getId());
    }

    @Override
    public void deleteUser(Long userId) {
        String sql = "DELETE FROM Users WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phoneNumber"));
            return user;
        }
    }
}
