package com.cube.servlet;

import com.cube.dao.*;
import com.cube.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class ProjectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Project> list = new ProjectDao().list();
        for (Project project:list)
        {
            CompetitionDao competitionDao = new CompetitionDao();
            List<Competition> competitions = competitionDao.get(project);
            project.setCompetitions(competitions);
        }
        req.getSession().setAttribute("project",list);
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role=req.getParameter("role");
        if(role.equals("manage"))
        {
            String method=req.getParameter("method");
            if(method.equals("manage"))
            {
                String id=req.getParameter("id");
                int pid=Integer.valueOf(id);
                Project project = new ProjectDao().get(pid);
                req.setAttribute("item",project);
                req.getRequestDispatcher("projectManage.jsp").forward(req,resp);
            }
            else if(method.equals("delete"))
            {
                String id=req.getParameter("id");
                int pid=Integer.valueOf(id);
                deleteProject(pid);
                updateProject(req);
                req.getRequestDispatcher("sport.jsp").forward(req,resp);
            }
            else if(method.equals("update"))
            {
                String id=req.getParameter("id");
                int pid=Integer.valueOf(id);
                Project project = new Project();
                String name = req.getParameter("name");
                String detail = req.getParameter("detail");
                String position = req.getParameter("position");
                String startTime = req.getParameter("startTime");
                String endTime = req.getParameter("endTime");
                project.setId(pid);
                project.setName(name);
                project.setDetail(detail);
                project.setPostion(position);
                project.setStartTime(Timestamp.valueOf(startTime.replace("T"," ")+":00"));
                project.setEndTime(Timestamp.valueOf(endTime.replace("T"," ")+":00"));
                ProjectDao projectDao = new ProjectDao();
                projectDao.update(project);
                updateProject(req);
                req.getRequestDispatcher("sport.jsp").forward(req,resp);
            }
            else if(method.equals("add"))
            {
                Project project = new Project();
                String name = req.getParameter("name");
                String detail = req.getParameter("detail");
                String position = req.getParameter("position");
                String startTime = req.getParameter("startTime");
                String endTime = req.getParameter("endTime");
                project.setName(name);
                project.setDetail(detail);
                project.setPostion(position);
                String replace = startTime.replace("T", " ");
                String s = startTime.replace("T", " ") + ":00";
                project.setStartTime(Timestamp.valueOf(startTime.replace("T"," ")+":00"));
                project.setEndTime(Timestamp.valueOf(endTime.replace("T"," ")+":00"));
                ProjectDao projectDao = new ProjectDao();
                projectDao.add(project);
                updateProject(req);
                req.getRequestDispatcher("sport.jsp").forward(req,resp);
            }
        }
    }
    void deleteProject(int id)
    {
        new ProjectDao().delete(id);
    }
    void updateProject(HttpServletRequest request)
    {
        List<Project> list = new ProjectDao().list();
        for (Project cur:list)
        {
            CompetitionDao competitionDao = new CompetitionDao();
            List<Competition> competitions = competitionDao.get(cur);
            cur.setCompetitions(competitions);
        }
        request.getSession().setAttribute("project",list);
    }
}
