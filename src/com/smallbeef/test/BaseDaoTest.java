package com.smallbeef.test;

import com.smallbeef.dao.impl.UserDaoImpl;
import org.junit.Test;

public class BaseDaoTest {
    @Test
    public void testBaseDao() {
        new UserDaoImpl();
    }
}
