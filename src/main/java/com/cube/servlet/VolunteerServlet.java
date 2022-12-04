package com.cube.servlet;

import com.cube.dao.ProjectDao;
import com.cube.dao.VolunteerDao;
import com.cube.pojo.Project;
import com.cube.pojo.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VolunteerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("add"))
        {
            int pid = Integer.parseInt(req.getParameter("pid"));
            Project project = new ProjectDao().get(pid);
            String server=req.getParameter("server");
            Volunteer volunteer =(Volunteer) req.getSession().getAttribute("volunteer");
            new VolunteerDao().add(volunteer);
        }
        else if(method.equals("break"))
        {
            Volunteer volunteer = (Volunteer)req.getSession().getAttribute("volunteer");
            req.getSession().setAttribute("volunteer",new VolunteerDao().get(volunteer.getId()));
        }
        else if(method.equals("update"))
        {
            int pid = Integer.parseInt(req.getParameter("pid"));
            Project project = new ProjectDao().get(pid);
            String server=req.getParameter("server");
            Volunteer volunteer =(Volunteer) req.getSession().getAttribute("volunteer");
            volunteer.setServer(server);
            new VolunteerDao().update(volunteer);
        }
    }
}
