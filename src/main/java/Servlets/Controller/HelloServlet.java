package Servlets.Controller;

//import org.apache.log4j.Logger;


import Servlets.POJO_Stud.Student;
import Servlets.Service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HelloServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
   //private  static Logger logger = Logger.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String catId = req.getParameter("catId");
        resp.getWriter().println("catId= "+ catId);
//        if(catId!= null){
//            List<Student> students = studentService.getStudentsByID(Integer.parseInt(catId));
//            for (Student student : students){
//                resp.getWriter().println(student.getSchedule()+ student.getName()+ student.getLast_name());
//            }
//        }else {
//            resp.getWriter().println("Sorry, bro ...");
//
//        }
    }
}
