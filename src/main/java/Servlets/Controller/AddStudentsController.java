package Servlets.Controller;

import Servlets.POJO_Stud.Student;
import Servlets.Service.StudentService;
import Servlets.Service.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentsController extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddStudentsController.class);
    private StudentService studentService = new StudentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует get запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);
        logger.info("конец работы get запроса");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует Post запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Student student = new Student(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("lastName"),
                Integer.parseInt(req.getParameter("course")));
        studentService.addStudent(student);
        resp.sendRedirect("/professor/add");
        logger.info("конец работы post запроса");
    }
}
