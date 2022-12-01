package com.dao;

import com.cube.dao.AdminDao;
import org.junit.jupiter.api.Test;

public class AdminTest {
    @Test
    void testAdmin()
    {
        AdminDao adminDao = new AdminDao();

        System.out.println(adminDao.get(1).getName());
    }
}
