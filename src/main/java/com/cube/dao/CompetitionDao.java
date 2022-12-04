package com.cube.dao;

import com.cube.pojo.Athlete;
import com.cube.pojo.Competition;
import com.cube.pojo.Project;
import com.cube.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDao {
    public void add(Athlete athlete, Project project,int score)
    {
        String sql = "insert into competition values(? ,? ,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, athlete.getId());
            ps.setInt(2,project.getId());
            ps.setInt(3, score);
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void delete(Athlete athlete)
    {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from competition where athlete_id = " + athlete.getId();

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void delete(Project project)
    {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from competition where project_id = " + project.getId();

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void delete(Project project,Athlete athlete)
    {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from competition where project_id = " + project.getId();
            sql+=" and athlete_id ="+athlete.getId();

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void updateScore(Athlete athlete, Project project,int score)
    {
        String sql = "update competition set score= ?  where athlete_id=? and project_id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(2, athlete.getId());
            ps.setInt(3,project.getId());
            ps.setInt(1, score);


            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public List<Competition> list() {
        return list(0, Short.MAX_VALUE);
    }
    public List<Competition> list(int start,int count)
    {
        List<Competition> beans = new ArrayList<Competition>();

        String sql = "select * from competition order by project_id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Competition bean=new Competition();
                int aid=rs.getInt(1);
                int pid=rs.getInt(2);
                int score=rs.getInt(3);
                bean.setAthlete(new AthleteDao().get(aid));
                bean.setProject(new ProjectDao().get(pid));
                bean.setScore(score);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public List<Competition> get(Athlete athlete) {
        List<Competition> beans = new ArrayList<Competition>();
        int id=athlete.getId();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from competition where athlete_id = " + id;

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Competition bean=new Competition();
                int aid=rs.getInt(1);
                int pid=rs.getInt(2);
                int score=rs.getInt(3);
                bean.setAthlete(new AthleteDao().get(aid));
                bean.setProject(new ProjectDao().get(pid));
                bean.setScore(score);
                beans.add(bean);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public List<Competition> get(Project project) {
        List<Competition> beans = new ArrayList<Competition>();
        int id=project.getId();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from competition where project_id = " + id;

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Competition bean=new Competition();
                int aid=rs.getInt(1);
                int pid=rs.getInt(2);
                int score=rs.getInt(3);
                bean.setAthlete(new AthleteDao().get(aid));
                bean.setProject(new ProjectDao().get(pid));
                bean.setScore(score);
                beans.add(bean);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
