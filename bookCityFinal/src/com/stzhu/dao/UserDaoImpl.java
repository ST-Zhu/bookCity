package com.stzhu.dao;

import com.stzhu.bean.User;


public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User queryByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return select(User.class, sql, username);
    }

    @Override
    public User queryByNameWord(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return select(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (username, password, email) values (?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
