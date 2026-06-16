package com.lab.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.lab.bean.SessionBean;

public class SessionDAO {

    private String jdbcURL =
            "jdbc:mysql://localhost:3306/drivesmart_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    jdbcURL,
                    jdbcUsername,
                    jdbcPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public void bookSession(SessionBean session) {

        String sql =
        "INSERT INTO Training_Sessions(student_name,"
      + "branch_location,lesson_type,status)"
      + " VALUES(?,?,?,?)";

        try (
            Connection con = getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql)
        ) {

            ps.setString(1, session.getStudent_name());
            ps.setString(2, session.getBranch_location());
            ps.setString(3, session.getLesson_type());
            ps.setString(4, session.getStatus());

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<SessionBean> getAllSessions() {

        List<SessionBean> list = new ArrayList<>();

        String sql =
        "SELECT * FROM Training_Sessions "
      + "ORDER BY branch_location ASC";

        try (
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)
        ) {

            while(rs.next()) {

                SessionBean s = new SessionBean();

                s.setSession_id(rs.getInt("session_id"));
                s.setStudent_name(rs.getString("student_name"));
                s.setBranch_location(rs.getString("branch_location"));
                s.setLesson_type(rs.getString("lesson_type"));
                s.setStatus(rs.getString("status"));

                list.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}