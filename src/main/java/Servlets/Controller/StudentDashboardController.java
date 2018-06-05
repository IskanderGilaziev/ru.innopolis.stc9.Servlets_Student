package Servlets.Controller;

import Servlets.Service.StudentService;
import Servlets.Service.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentDashboardController extends HttpServlet {
    private static Logger logger = Logger.getLogger(StudentDashboardController.class);
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Student Dashboard get start");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        String idStudent= req.getParameter("id");
//        int id = Integer.parseInt(idStudent);
        req.setAttribute("nameStudent", studentService.getAllStudent());
        req.getRequestDispatcher("/student_dashboard.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
       super.doPost(req,resp);
    }
}
