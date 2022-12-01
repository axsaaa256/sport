package com.cube.dao;

import com.cube.pojo.Admin;
import com.cube.util.DBUtil;

import java.sql.*;

public class AdminDao {
    public Admin get(int id) {
        Admin bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "select * from admin where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Admin();
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
    public Admin get(String account, String password) {
        Admin bean = null;
        String sql = "select * from admin where account = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Admin();
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
