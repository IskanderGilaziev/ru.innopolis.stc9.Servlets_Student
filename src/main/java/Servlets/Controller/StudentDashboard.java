package Servlets.Controller;

import Servlets.DAO_Stud.StudentDAOImpl;
import Servlets.POJO_Stud.Student;
import Servlets.Service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDashboard extends HttpServlet {
    private StudentDAOImpl studentDAO = new StudentDAOImpl();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        ArrayList listStudent= null;
        listStudent = studentService.getNameStudent();
        req.setAttribute("listStudent", listStudent);

        req.getRequestDispatcher("/student_dashboard.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
       super.doPost(req,resp);
    }
}
