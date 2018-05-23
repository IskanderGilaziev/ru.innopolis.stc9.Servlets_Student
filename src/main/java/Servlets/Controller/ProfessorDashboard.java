package Servlets.Controller;

import Servlets.POJO_Stud.Professor;
import Servlets.Service.ProfessorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDashboard extends HttpServlet {
    ProfessorService professorService ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfessorService professorService = new ProfessorService();
        ArrayList<Professor> listProf= (ArrayList<Professor>) professorService.getAllProfessor();
        req.setAttribute("listProfessor",listProf);
        req.getRequestDispatcher("/professor_dashboard.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
