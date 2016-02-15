package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by seed on 16/2/14.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sql = "insert into t_login_log (user_id,ip,login_datetime) values (?,?,?) ";
        jdbcTemplate.update(sql,loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate());
    }
}
