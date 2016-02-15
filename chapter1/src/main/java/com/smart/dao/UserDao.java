package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by seed on 16/2/12.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String password){
        String sql = "select count(*) from t_user "
                + " where user_name =? and password =? ";
        return jdbcTemplate.queryForInt(sql,userName,password);
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        String sql = "select * from t_user " +
                " where user_name =?";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserid(resultSet.getInt("user_id"));
                user.setUserName(userName);
            }
        },userName);
        return user;

    }

    public void updateLoginInfo(User user){
        String sql = "update t_user set last_visit =?,last_ip =? " +
                " where user_id =?";
        jdbcTemplate.update(sql,user.getLastVisit(),user.getLastIp(),user.getUserid());
    }
}
