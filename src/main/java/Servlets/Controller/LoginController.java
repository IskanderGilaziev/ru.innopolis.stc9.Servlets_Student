package Servlets.Controller;




import Servlets.Service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginController extends HttpServlet {
   private UserService userService = new UserService();
    private static Logger logger = Logger.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        userService.doGetAuth(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        userService.doPostAuth(req, resp);
    }
}