package com.cube.dao;

import com.cube.pojo.Project;
import com.cube.pojo.Referee;
import com.cube.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefereeDao {

    public void add(Referee bean) {

        String sql = "insert into referee values(null,? ,? ,?,null)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(2,bean.getAccount());
            ps.setString(1, bean.getName());
            ps.setString(3, bean.getPassword());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Referee bean) {

        String sql = "update referee set account= ? , password = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, bean.getAccount());
            ps.setString(2, bean.getPassword());
            ps.setInt(3, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void update(Referee bean,Project project) {

        String sql = "update referee set project_id=? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1,project.getId());
            ps.setInt(2, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from referee where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Referee> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Referee> list(int start, int count) {
        List<Referee> beans = new ArrayList<Referee>();

        String sql = "select * from referee order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Referee bean = new Referee();
                int id = rs.getInt(1);
                String account=rs.getString("account");
                bean.setAccount(account);
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                int pid=rs.getInt("project_id");
                Project project = new ProjectDao().get(pid);
                bean.setProject(project);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public Referee get(int id) {
        Referee bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from referee where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Referee();
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                String account=rs.getString("account");
                bean.setAccount(account);
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
    public Referee get(String account, String password) {
        Referee bean = null;
        String sql = "select * from referee where account = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Referee();
                String name=rs.getString("name");
                int id = rs.getInt("id");
                bean.setAccount(account);
                bean.setPassword(password);
                bean.setName(name);
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
}
