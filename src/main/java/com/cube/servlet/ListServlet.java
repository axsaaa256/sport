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
import java.io.IOException;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        request=req;
        response=resp;
        String role = req.getParameter("role");
        switch (role)
        {
            case "volunteer":
                break;
            case "referee":
                break;
            case "role":
                break;
        }
    }
    public void ListVolunteer()
    {

    }
}
