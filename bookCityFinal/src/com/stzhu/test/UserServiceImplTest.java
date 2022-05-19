package com.stzhu.test;

import com.stzhu.bean.User;
import com.stzhu.service.UserServiceImpl;
import org.junit.Test;

public class UserServiceImplTest {
    private UserServiceImpl usi = new UserServiceImpl();

    @Test
    public void register() {
        boolean tf = usi.register(new User("赵六", "123456", "zhaoliu@123.com"));
        System.out.println(tf);
    }

    @Test
    public void login() {
        User tf = usi.login(new User("zhangsan1", "123456", "zhangsan@123.com"));
        System.out.println(tf);
    }

    @Test
    public void exist() {
        boolean tf = usi.exist("张三");
        System.out.println(tf);
    }
}