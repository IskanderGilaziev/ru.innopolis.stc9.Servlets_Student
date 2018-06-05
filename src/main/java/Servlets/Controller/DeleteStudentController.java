package Servlets.Controller;

import Servlets.Service.StudentService;
import Servlets.Service.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentController extends HttpServlet {
    private static Logger logger = Logger.getLogger(DeleteStudentController.class);
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует get запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("students", studentService.getAllStudent());
        req.getRequestDispatcher("/deleteStudent.jsp").forward(req, resp);
        logger.info("конец работы get запроса");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует Post запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int idStudent = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudentByID(idStudent);
        resp.sendRedirect("/professor/delete?studentId=" + idStudent);
        logger.info("конец работы post запроса");
    }
}
