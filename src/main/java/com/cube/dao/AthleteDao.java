package com.cube.dao;

import com.cube.pojo.Admin;
import com.cube.pojo.Athlete;
import com.cube.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AthleteDao {
    public void add(Athlete bean) {

        String sql = "insert into athlete values(null,? ,? ,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(2,bean.getAccount());
            ps.setString(1, bean.getName());
            ps.setString(3, bean.getPassword());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Athlete bean) {

        String sql = "update athlete set account= ? , password = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, bean.getAccount());
            ps.setString(2, bean.getPassword());
            ps.setInt(3, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from athlete where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public List<Athlete> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Athlete> list(int start, int count) {
        List<Athlete> beans = new ArrayList<Athlete>();

        String sql = "select * from athlete order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Athlete bean = new Athlete();
                int id = rs.getInt(1);
                String account=rs.getString("account");
                bean.setAccount(account);
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);

                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
    public Athlete get(int id) {
        Athlete bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from athlete where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Athlete();
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                String account=rs.getString("account");
                bean.setAccount(account);
                bean.setId(id);
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
