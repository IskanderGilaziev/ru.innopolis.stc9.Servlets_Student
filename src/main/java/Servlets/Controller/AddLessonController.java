package Servlets.Controller;

import Servlets.POJO_Stud.Lesson;
import Servlets.Service.LessonService;
import Servlets.Service.LessonServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLessonController extends HttpServlet {

    private static Logger logger = Logger.getLogger(AddLessonController.class);
    private LessonService lessonService = new LessonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует get запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/addLesson.jsp").forward(req, resp);
        logger.info("конец работы get запроса");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Стартует Post запрос");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Lesson homeWork = new Lesson(
                Integer.parseInt(req.getParameter("id")),
                Integer.parseInt(req.getParameter("idStudent")),
                Integer.parseInt(req.getParameter("idProfessor")),
                req.getParameter("theme"),
                Boolean.parseBoolean("isLesson"));
        lessonService.addLesson(homeWork);
        resp.sendRedirect("/professor/addLesson");
        logger.info("конец работы Post запроса");

    }
}
