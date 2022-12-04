package com.cube.servlet;

import com.cube.dao.*;
import com.cube.pojo.Project;
import com.cube.pojo.Referee;
import com.cube.pojo.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RefereeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Referee referee= (Referee)req.getSession().getAttribute("referee");
        Project project = referee.getProject();
        String method = req.getParameter("method");
        int pid=Integer.parseInt(req.getParameter("pid"));
        if(method.equals("setScore"))
        {
            pid=Integer.parseInt(req.getParameter("pid"));
            int aid=Integer.parseInt(req.getParameter("aid"));
            int score=Integer.parseInt(req.getParameter("score"));
            new CompetitionDao().updateScore(new AthleteDao().get(aid),new ProjectDao().get(pid),score);
            req.getRequestDispatcher("listOfCompetition.jsp").forward(req,resp);
        }
        else if(method.equals("add"))
        {
            pid=Integer.parseInt(req.getParameter("pid"));
            new RefereeDao().add(referee,new ProjectDao().get(pid));
        }
        else if(method.equals("break"))
        {
            Referee volunteer = (Referee) req.getSession().getAttribute("volunteer");
            req.getSession().setAttribute("referee",new RefereeDao().get(referee.getId()));
        }
    }
}
