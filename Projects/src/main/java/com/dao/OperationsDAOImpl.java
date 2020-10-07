package com.dao;

import com.model.Transfer;
import com.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


@Service
public class OperationsDAOImpl implements OperationsDAO {


    private JdbcTemplate jdbcTemplate;

    public OperationsDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> userList = jdbcTemplate.query("SELECT * FROM users", new RowMapper<Users>() {



            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                Users user = new Users();

                user.setSl_no(rs.getInt("sl_no"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCredits(rs.getLong("credits"));

                return user;
            }

        });

        return userList;
    }

    @Override
    public List<Users> getUser(String fullName) {
        List<Users> userList = jdbcTemplate.query("SELECT * FROM users WHERE name = ?", new Object[]{fullName}, new RowMapper<Users>() {


            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                Users user = new Users();

                user.setSl_no(rs.getInt("Sl_no"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCredits(rs.getLong("credits"));


                return user;

            }
        });
        return userList;
    }

    @Override
    public int updateTransaction(String from, String to, long credit) {
        String sql = "insert into transfer(credit_from,credit_to,transferred_amt) values(?,?,?)";

        try {

            int counter = jdbcTemplate.update(sql,
                    new Object[] { from, to, credit});

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateFromUser(String from, long credit) {
        long existingCredit = 0;
        String sql = "update users set credits=? where name=?";
        List<Users> usr = getUser(from);
        for (Users u: usr) {
            existingCredit = u.getCredits();
        }

        try {

            int counter = jdbcTemplate.update(sql,
                    new Object[] { (existingCredit - credit), from});

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }




    @Override
    public int updateToUser(String to, long credit) {
        long existingCredit = 0;
        String sql = "update users set credits=? where name=?";
        List<Users> usr = getUser(to);
        for (Users u: usr) {
            existingCredit = u.getCredits();
        }

        try {

            long sum = Long.sum(existingCredit,credit);

            int counter = jdbcTemplate.update(sql,
                    new Object[] { sum , to});

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



}


