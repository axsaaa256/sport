package com.cube.servlet;

import com.cube.dao.*;
import com.cube.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        String role=req.getParameter("role");
        if(!check(account,password,role))
        {
            req.setAttribute("error_info","账号或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        List<Project> list = new ProjectDao().list();
        for (Project project:list)
        {
            CompetitionDao competitionDao = new CompetitionDao();
            List<Competition> competitions = competitionDao.get(project);
            project.setCompetitions(competitions);
        }
        session.setAttribute("project",list);
        switch (role)
        {
            case "volunteer":
                break;
            case "referee":
                break;
            case "athlete":
                break;
        }
        System.out.println(session.getAttribute("project"));
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
    public boolean check(String account,String password,String role)
    {
        if(role.equals("refee"))
        {
            RefereeDao refereeDao = new RefereeDao();
            Referee referee = refereeDao.get(account, password);
            if(referee==null)
            {
                return false;
            }
            session.setAttribute("referee",referee);
        }
        else if(role.equals("volunteer"))
        {
            VolunteerDao volunteerDao = new VolunteerDao();
            Volunteer volunteer = volunteerDao.get(account, password);
            if(volunteer==null)
            {
                return false;
            }
            session.setAttribute("volunteer",volunteer);
        }
        else if (role.equals("athlete"))
        {
            AthleteDao athleteDao = new AthleteDao();
            Athlete athlete = athleteDao.get(account, password);
            if(athlete==null)
            {
                return false;
            }
            session.setAttribute("athlete",athlete);
        }
        else
            return false;
        return true;
    }
}
