package Servlets.Controller;

import Servlets.Service.ProfessorService;
import Servlets.Service.ProfessorServiceImpl;
import Servlets.Service.StudentService;
import Servlets.Service.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfessorDashboardController extends HttpServlet {
    private static Logger logger = Logger.getLogger(ProfessorDashboardController.class);
    private ProfessorService professorService = new ProfessorServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Its worked");
        req.setAttribute("students", studentService.getAllStudent());
        req.getRequestDispatcher("/professor_dashboard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
