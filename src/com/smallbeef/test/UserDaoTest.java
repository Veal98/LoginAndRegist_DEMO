package com.smallbeef.test;

import com.smallbeef.bean.User;
import com.smallbeef.dao.UserDao;
import com.smallbeef.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    @Test
    //测试注册
    public void testregistUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.registUser(new User(0, "abcde", "abcde"));
    }

    // 测试根据id查询
    @Test
    public void testgetUserByUserNameAndPassWord() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByUserNameAndPassWord(new User(0, "abcd", "abcd"));
        System.out.println(user);

    }
}
