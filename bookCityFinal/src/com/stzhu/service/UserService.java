package com.stzhu.service;

import com.stzhu.bean.User;

public interface UserService {
    /**
     * 注册账户
     * @param user
     * @return  成功:true
     *          失败:false
     */
    public boolean register(User user);

    /**
     * 登录账户
     * @param user
     * @return  成功:true
     *          失败:false
     */
    public User login(User user);

    /**
     * 检测用户名是否存在
     * @param username
     * @return  成功:true
     *          失败:false
     */
    public boolean exist(String username);
}
