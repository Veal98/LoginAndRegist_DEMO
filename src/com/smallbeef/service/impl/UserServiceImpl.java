package com.smallbeef.service.impl;

import com.smallbeef.bean.User;
import com.smallbeef.dao.UserDao;
import com.smallbeef.dao.impl.UserDaoImpl;
import com.smallbeef.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();

    @Override
    public User login(User user) {
        return ud.getUserByUserNameAndPassWord(user);
    }

    @Override
    public boolean regist(User user) {
        return (ud.registUser(user));

    }
}
