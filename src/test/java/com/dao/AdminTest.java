package com.dao;

import com.cube.dao.AdminDao;
import com.cube.dao.AthleteDao;
import com.cube.dao.RefereeDao;
import com.cube.dao.VolunteerDao;
import com.cube.pojo.Admin;
import com.cube.pojo.Athlete;
import com.cube.pojo.Referee;
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
    void testReferee()
    {
        RefereeDao refeeDao = new RefereeDao();
        Referee admin = new Referee("胡明珍", "2021", "1234");
        refeeDao.add(admin);
        List<Referee> list = refeeDao.list();
        System.out.println(list);
        admin.setName("呜呜呜");
        refeeDao.update(admin);
        System.out.println(refeeDao.get("2020","1234"));
        refeeDao.delete(admin.getId());
        refeeDao.list(0,5);
    }
    @Test
    void testAthlete()
    {
        AthleteDao adminDao = new AthleteDao();
        Athlete athlete = new Athlete("胡明珍", "2021", "1234");
        adminDao.add(athlete);
        List<Athlete> list = adminDao.list();
        System.out.println(list);
        athlete.setName("呜呜呜");
        adminDao.update(athlete);
        System.out.println(adminDao.get("2020","1234"));
        adminDao.delete(athlete.getId());
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
