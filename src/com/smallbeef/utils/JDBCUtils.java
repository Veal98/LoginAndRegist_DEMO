package com.smallbeef.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 获取数据库连接的工具类
 *
 * @author smallbeef
 *
 */
public class JDBCUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource(
            "c3p0Config");

    private JDBCUtils() {
    }

    /**
     * 获取数据库连接
     *
     * @return 如果获取连接成功，返回数据的连接对象。<br/>
     *         如果获取数据库连接失败，则返回null
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 从c3p0中获取数据库连接
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放数据库连接
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}