package com.cube.dao;

import com.cube.pojo.Project;
import com.cube.pojo.Referee;
import com.cube.pojo.Volunteer;
import com.cube.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteerDao {
    public void add(Volunteer bean) {

        String sql = "insert into volunteer values(null,? ,? ,?,?,null)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(2,bean.getAccount());
            ps.setString(1, bean.getName());
            ps.setString(3, bean.getPassword());
            ps.setString(4,bean.getServer());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void add(Volunteer bean,Project project) {

        String sql = "insert into volunteer values(null,? ,? ,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(2,bean.getAccount());
            ps.setString(1, bean.getName());
            ps.setString(3, bean.getPassword());
            ps.setString(4,bean.getServer());
            ps.setInt(5,project.getId());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Volunteer bean) {

        String sql = "update volunteer set account= ? , password = ?,server = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, bean.getAccount());
            ps.setString(2, bean.getPassword());

            ps.setString(3,bean.getServer());
            ps.setInt(4, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from volunteer where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public List<Volunteer> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Volunteer> list(int start, int count) {
        List<Volunteer> beans = new ArrayList<Volunteer>();

        String sql = "select * from volunteer order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Volunteer bean = new Volunteer();
                int id = rs.getInt(1);
                String account=rs.getString("account");
                bean.setAccount(account);
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                String server=rs.getString("server");
                bean.setServer(server);
                bean.setId(id);
                beans.add(bean);
                int pid=rs.getInt("project_id");
                Project project = new ProjectDao().get(pid);
                bean.setProject(project);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public Volunteer get(int id) {
        Volunteer bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from volunteer where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Volunteer();
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                String account=rs.getString("account");
                bean.setAccount(account);
                String server=rs.getString("server");
                bean.setServer(server);
                bean.setId(id);
                int pid=rs.getInt("project_id");
                Project project = new ProjectDao().get(pid);
                bean.setProject(project);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }
    public Volunteer get(String account, String password) {
        Volunteer bean = null;
        String sql = "select * from volunteer where account = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Volunteer();
                String name=rs.getString("name");
                int id = rs.getInt("id");
                bean.setAccount(account);
                bean.setPassword(password);
                bean.setName(name);
                String server=rs.getString("server");
                bean.setServer(server);
                bean.setId(id);
                int pid=rs.getInt("project_id");
                Project project = new ProjectDao().get(pid);
                bean.setProject(project);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }
    public void update(Volunteer bean, Project project) {

        String sql = "update volunteer set project_id=? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1,project.getId());
            ps.setInt(2, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
