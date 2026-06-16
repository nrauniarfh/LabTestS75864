package com.lab.controller;

import com.lab.dao.SessionDAO;
import com.lab.bean.SessionBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class BookSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String studentName =
                request.getParameter("student_name");

        String branchLocation =
                request.getParameter("branch_location");

        String lessonType =
                request.getParameter("lesson_type");

        SessionBean session = new SessionBean();

        session.setStudent_name(studentName);
        session.setBranch_location(branchLocation);
        session.setLesson_type(lessonType);
        session.setStatus("Booked");

        SessionDAO dao = new SessionDAO();
        dao.bookSession(session);

        response.sendRedirect("ScheduleServlet");
    }
}