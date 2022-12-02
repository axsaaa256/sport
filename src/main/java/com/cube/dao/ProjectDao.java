package com.cube.dao;

import com.cube.pojo.Athlete;
import com.cube.pojo.Project;
import com.cube.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    public void add(Project bean) {

        String sql = "insert into project values(null,? ,? ,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getDetail());
            ps.setString(3,bean.getPostion());
            ps.setTimestamp(4,bean.getStartTime());
            ps.setTimestamp(5,bean.getEndTime());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Project bean) {

        String sql = "update project set name= ? , detail = ?, position=?,startTime=? , endTime = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getDetail());
            ps.setString(3,bean.getPostion());
            ps.setTimestamp(4,bean.getStartTime());
            ps.setTimestamp(5,bean.getEndTime());
            ps.setInt(6,bean.getId());


            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from project where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public List<Project> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Project> list(int start, int count) {
        List<Project> beans = new ArrayList<Project>();

        String sql = "select * from project order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Project bean = new Project();
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setDetail(rs.getString(3));
                bean.setPostion(rs.getString(4));
                bean.setStartTime(rs.getTimestamp(5));
                bean.setEndTime(rs.getTimestamp(6));
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public Project get(int id) {
        Project bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from project where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Project();
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setDetail(rs.getString(3));
                bean.setPostion(rs.getString(4));
                bean.setStartTime(rs.getTimestamp(5));
                bean.setEndTime(rs.getTimestamp(6));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }
    public Athlete get(String account, String password) {
        Athlete bean = null;
        String sql = "select * from athlete where account = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Athlete();
                String name=rs.getString("name");
                int id = rs.getInt("id");
                bean.setAccount(account);
                bean.setPassword(password);
                bean.setName(name);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

}
