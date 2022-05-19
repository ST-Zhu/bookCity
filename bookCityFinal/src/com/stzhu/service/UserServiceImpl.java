package com.stzhu.service;

import com.stzhu.bean.User;
import com.stzhu.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDaoImpl udi = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        int count = udi.saveUser(user);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return udi.queryByNameWord(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean exist(String username) {
        User temp = udi.queryByUsername(username);
        if (temp != null) {
            return true;
        }
        return false;
    }
}
