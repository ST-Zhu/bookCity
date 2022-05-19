package com.stzhu.test;

import com.stzhu.bean.User;
import com.stzhu.dao.UserDaoImpl;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDaoImpl udi = new UserDaoImpl();

    @Test
    public void queryByUsername() {
        System.out.println(udi.queryByUsername("zhangsan"));
    }

    @Test
    public void queryByNameWord() {
        System.out.println(udi.queryByNameWord("zhangsan", "1234"));
    }

    @Test
    public void saveUser() {
        System.out.println(udi.saveUser(new User("王五", "123456", "wangwu@123.com")));
    }
}