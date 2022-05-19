package com.stzhu.dao;

import com.stzhu.bean.User;
import com.stzhu.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public abstract class BaseDao {
    private QueryRunner qr = new QueryRunner();

    /**
     * update() 方法用来执行：Insert\Update\Delete语句
     * @param sql
     * @param args
     * @return  成功：返回更新数据的条数
     *          失败：-1
     */
    public int update(String sql, Object... args) {
        Connection conn = DBUtil.getConnection();
        try {
            return qr.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 采用 PreparedStatement， 查询数据库数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return  成功：返回查询的bean类
     *          失败：返回null
     */
    public <T> T select(Class<T> type, String sql, Object... args) {
        Connection conn = DBUtil.getConnection();
        try {
           return qr.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }

    /**
     * 查询多个数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return  成功：返回查询的数据列表
     *          失败：null
     */
    public <T> List<T> selectList(Class<T> type, String sql, Object... args) {
        Connection conn = DBUtil.getConnection();
        try {
            return qr.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个值
     * @param sql
     * @param args
     * @return  成功：返回数值
     *          失败：null
     */
    public Object selectSingle(String sql, Object... args) {
        Connection conn = DBUtil.getConnection();
        try {
            return qr.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
