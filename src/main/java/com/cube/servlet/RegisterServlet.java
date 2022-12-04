package com.cube.servlet;

import com.cube.dao.AthleteDao;
import com.cube.dao.RefereeDao;
import com.cube.dao.VolunteerDao;
import com.cube.pojo.Athlete;
import com.cube.pojo.Referee;
import com.cube.pojo.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        req.setCharacterEncoding("utf-8");
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        String role=req.getParameter("role");
        String name=req.getParameter("name");
        if(!register(account,password,name,role))
        {
            req.setAttribute("error_info","注册失败");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
    public boolean register(String account,String password,String name,String role)
    {
        if(role.equals("refee"))
        {
            RefereeDao refereeDao = new RefereeDao();
            Referee referee = new Referee(name,account,password);
            refereeDao.add(referee);
        }
        else if(role.equals("volunteer"))
        {
            VolunteerDao volunteerDao = new VolunteerDao();
            Volunteer volunteer =new Volunteer(name,account,password);
            volunteerDao.add(volunteer);
        }
        else if (role.equals("athlete"))
        {
            AthleteDao athleteDao = new AthleteDao();
            Athlete athlete = new Athlete(name,account,password);
            athleteDao.add(athlete);
        }
        else
            return false;
        return true;
    }

}
