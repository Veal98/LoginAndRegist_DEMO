package com.smallbeef.dao;

import com.smallbeef.bean.User;

public interface UserDao {
    /**
     * 按照用户名和密码查询信息
     * @param user
     * @return
     */
    public User getUserByUserNameAndPassWord(User user);

    /**
     * 注册 保存用户
     * @param user
     * @return
     */
    public boolean registUser(User user);
}
