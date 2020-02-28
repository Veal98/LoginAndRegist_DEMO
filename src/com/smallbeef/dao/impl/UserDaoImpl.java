package com.smallbeef.dao.impl;

import com.smallbeef.bean.User;
import com.smallbeef.dao.BaseDao;
import com.smallbeef.dao.UserDao;

/**
 * UserDAO具体的实现类
 *
 * @author smallbeef
 *
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    /**
     * 按照用户名和密码查询信息
     * @param user
     * @return
     */
    @Override
    public User getUserByUserNameAndPassWord(User user) {
        String sql = "select id,username,password from user where username = ? and password = ?";
        User bean = this.getBean(sql, user.getUsername(), user.getPassword());
        return bean;
    }

    /**
     * 注册 保存用户
     * @param user
     * @return
     */
    @Override
    public boolean registUser(User user) {
        String sql = "insert into user(`id`,`username`,`password`) values(null, ?, ?)";
        int update = this.update(sql, user.getUsername(), user.getPassword());
        System.out.println(update);
        return update>0;
    }
}
