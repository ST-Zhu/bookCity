package com.stzhu.dao;

import com.stzhu.bean.User;

public interface UserDao {
    /**
     * 通过用户名查询用户数据
     * @param username
     * @return  成功：用户信息
     *          失败；null
     */
    public User queryByUsername(String username);

    /**
     * 通过用户名和密码查询用户数据
     * @param username
     * @param password
     * @return  成功：用户信息
     *          失败：null
     */
    public User queryByNameWord(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return  成功：保存的条数
     *          失败：-1
     */
    public int saveUser(User user);
}
