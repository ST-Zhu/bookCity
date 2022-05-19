package com.stzhu.test;

import com.stzhu.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest {
    @Test
    public void dbUtilTest() {
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println(conn);
            DBUtil.commitClose();
        } catch (Exception e) {
            DBUtil.rollbackClose();
            e.printStackTrace();
        }
    }
}