package Servlets.Controller;

import Servlets.POJO_Stud.HomeWork;
import Servlets.Service.HomeWorkService;
import Servlets.Service.HomeWorkServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddHomeWorkController extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddHomeWorkController.class);
    private HomeWorkService homeWorkService = new HomeWorkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует get запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/addHomeWork.jsp").forward(req, resp);
        logger.info("конец работы get запроса");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует Post запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HomeWork homeWork = new HomeWork(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("homeWork"),
                Integer.parseInt(req.getParameter("idProfessor")));
        homeWorkService.addHomeWork(homeWork);
        resp.sendRedirect("/professor/addHomeWork");
        logger.info("конец работы post запроса");
    }
}
