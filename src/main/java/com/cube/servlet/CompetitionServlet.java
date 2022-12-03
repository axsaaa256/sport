package com.cube.servlet;

import com.cube.dao.CompetitionDao;
import com.cube.dao.ProjectDao;
import com.cube.pojo.Athlete;
import com.cube.pojo.Competition;
import com.cube.pojo.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method.equals("add"))
        {
            String id = req.getParameter("pid");
            int pid=Integer.parseInt(id);
            ProjectDao projectDao = new ProjectDao();
            Project project = projectDao.get(pid);
            Athlete athlete=(Athlete)req.getSession().getAttribute("athlete");
            CompetitionDao competitionDao = new CompetitionDao();
            competitionDao.add(athlete,project,0);
        }
        else if(method.equals("list"))
        {
            Athlete athlete=(Athlete)req.getSession().getAttribute("athlete");
            List<Competition> competitions = new CompetitionDao().get(athlete);
            List<Project> project =(List<Project> ) req.getSession().getAttribute("project");
            List<Project> availProject=new ArrayList<>();
            List<Project> partedProject=new ArrayList<>();
            for(Competition competition:competitions)
            {
                boolean flag=true;
                for(Project cur:project)
                {
                    if(competition.getProject().getId()==cur.getId())
                    {
                        flag=false;
                    }
                }
                if(flag)
                {
                    availProject.add(competition.getProject());
                }
            }
            req.getSession().setAttribute("competitions",competitions);
            req.getSession().setAttribute("availProject",availProject);
            req.getSession().setAttribute("partedProject",partedProject);
            req.getRequestDispatcher("listOfCompetitionAdd.jsp").forward(req,resp);
        }
        else if (method.equals("delete")) {
            String id = req.getParameter("pid");
            int pid=Integer.parseInt(id);
            ProjectDao projectDao = new ProjectDao();
            Project project = projectDao.get(pid);
            Athlete athlete=(Athlete)req.getSession().getAttribute("athlete");
            CompetitionDao competitionDao = new CompetitionDao();
            competitionDao.delete(project);

        }
        else if(method.equals("setScore")){
            String id = req.getParameter("pid");
            int pid=Integer.parseInt(id);
            int score=Integer.parseInt(req.getParameter("score"));
            ProjectDao projectDao = new ProjectDao();
            Project project = projectDao.get(pid);
            Athlete athlete=(Athlete)req.getSession().getAttribute("athlete");
            CompetitionDao competitionDao = new CompetitionDao();
            competitionDao.updateScore(athlete,project,score);
        }
    }
}
