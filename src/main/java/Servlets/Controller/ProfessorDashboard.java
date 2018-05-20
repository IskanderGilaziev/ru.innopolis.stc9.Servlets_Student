package Servlets.Controller;

import Servlets.Service.ProfessorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProfessorDashboard extends HttpServlet {
    ProfessorService professorService ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // ArrayList professorNames = professorService.getNameProfessor();
//        req.setAttribute("listProfessorName", professorNames);
        req.getRequestDispatcher("/professor_dashboard.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
