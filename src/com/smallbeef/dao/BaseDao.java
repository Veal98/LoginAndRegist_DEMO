package com.smallbeef.dao;

import com.smallbeef.utils.JDBCUtils;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    // 需要获取实际的type
    private Class<T> type;

    private QueryRunner queryRunner = new QueryRunner();

    @SuppressWarnings("unchecked")
    public BaseDao(){
        // 获取父类的类型,父类是带参数的
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        System.out.println(superclass.getClass());
        // 获取泛型中的具体的类型的class
        type = (Class<T>) superclass.getActualTypeArguments()[0];
    }

    /**
     * 获取一个对象
     * @param sql  sql语句
     * @param params 可变参数
     * @return
     */
    public T getBean(String sql, Object...params){
        Connection connection = JDBCUtils.getConnection();
        T query = null;
        try {
            // 查询一个数据
            query = queryRunner.query(connection,sql,new BeanHandler<>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return query;
    }

    /**
     * 获取对象的集合
     * @return
     */
    public List<T> getBeanList(String sql, Object...params){
        Connection connection = JDBCUtils.getConnection();
        List<T> query = null;
        try {
            // 查询一组数据
            query = queryRunner.query(connection,sql,new BeanListHandler<>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }

        return query;
    }

    /**
     * 执行增删改
     */
    public int update(String sql, Object ...params){
        int count = 0;
        Connection connection = JDBCUtils.getConnection();
        try {
            count = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return count;
    }
}
