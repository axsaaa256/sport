package com.dao;

import com.cube.dao.AdminDao;
import com.cube.dao.VolunteerDao;
import com.cube.pojo.Admin;
import com.cube.pojo.Volunteer;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AdminTest {
    @Test
    void testAdmin()
    {
        AdminDao adminDao = new AdminDao();
        Admin admin = new Admin("胡明珍", "2021", "1234");
        adminDao.add(admin);
        List<Admin> list = adminDao.list();
        System.out.println(list);
        admin.setName("呜呜呜");
        adminDao.update(admin);
        System.out.println(adminDao.get("2020","1234"));
        adminDao.delete(admin.getId());
        List<Admin> list1 = adminDao.list(0, 5);
        System.out.println(list1);
    }
    @Test
    void testRefee()
    {
        AdminDao adminDao = new AdminDao();
        Admin admin = new Admin("胡明珍", "2021", "1234");
        adminDao.add(admin);
        List<Admin> list = adminDao.list();
        System.out.println(list);
        admin.setName("呜呜呜");
        adminDao.update(admin);
        System.out.println(adminDao.get("2020","1234"));
        adminDao.delete(admin.getId());
        adminDao.list(0,5);
    }
    @Test
    void testAthlete()
    {
        AdminDao adminDao = new AdminDao();
        Admin admin = new Admin("胡明珍", "2021", "1234");
        adminDao.add(admin);
        List<Admin> list = adminDao.list();
        System.out.println(list);
        admin.setName("呜呜呜");
        adminDao.update(admin);
        System.out.println(adminDao.get("2020","1234"));
        adminDao.delete(admin.getId());
        adminDao.list(0,5);
    }@Test
    void testVolunteer()
    {
        VolunteerDao volunteerDao = new VolunteerDao();
        Volunteer volunteer = new Volunteer("胡明珍", "2021", "1234","");
        volunteerDao.add(volunteer);
        List<Volunteer> list = volunteerDao.list();
        System.out.println(list);
        volunteer.setServer("wqe");
        volunteerDao.update(volunteer);
        System.out.println(volunteerDao.get("2020","1234"));
        volunteerDao.delete(volunteer.getId());
        List<Volunteer> list1 = volunteerDao.list(0, 5);
        System.out.println(list1);
    }
    
    
    
}
