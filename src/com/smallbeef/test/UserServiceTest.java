package com.smallbeef.test;

import com.smallbeef.bean.User;
import com.smallbeef.service.UserService;
import com.smallbeef.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    //测试注册
    @Test
    public void testSaveUser() {
        // 注册用户
        UserService userService = new UserServiceImpl();

        boolean result = userService.regist(new User(null, "bbj", "bbj"));
        if (result) {
            System.out.println("保存数据库成功");
        } else {
            System.out.println("数据库保存不成功");
        }

    }

    // 测试登录
    @Test
    public void testgetUserByUserNameAndPassWord() {
        UserService userService = new UserServiceImpl();
        // 测试登录的业务
        User user = userService.login(new User(0, "yjc", "yjc"));
        System.out.println(user);

    }
}
