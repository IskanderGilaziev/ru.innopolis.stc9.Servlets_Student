package Servlets.Service;


import Servlets.DAO_Stud.UserDAO;
import Servlets.DAO_Stud.UserDaoImpl;
import Servlets.POJO_Stud.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService {
    private  static UserDAO<User> userDAO = new UserDaoImpl();
    private static Logger logger = Logger.getLogger(UserService.class);

    public boolean checkAuthorisation(String login, String password){
        User user =  userDAO.getByLogin(login);
        logger.info("user authorization: "+ user.getLogin());
        return (user != null) && (user.getPassword().equals(password));
    }

    public int getRole (String login){
        User user =  userDAO.getByLogin(login);
        logger.info("return user role: "+ user.getLogin());
        return  user.getRole();

    }


    public void doPostAuth(HttpServletRequest req, HttpServletResponse resp) {

        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        UserService userService = new UserService();
        //TODO: вылезает NPE, не могу найти ошибку.Нет подключения к БД.
//         if(userService.checkAuthorisation(login,password)){
         String login1="student";
              if((login1.equals(login)) && (login1.equals(password))){
//        Integer role = userService.getRole(login);//получаем роль при прохождении регистрации
        req.getSession().setAttribute("login", login);
        try {
            resp.sendRedirect(req.getContextPath() + "/student");
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
      //  req.getSession().setAttribute("role",role);
//        try {
//            switch (role) {
//                case 1:
//                    resp.sendRedirect(req.getContextPath() + "/professor");
//                    logger.info("Professor has entered ");
//                    return;
//                case 2:
//                    resp.sendRedirect(req.getContextPath() + "/student");
//                    logger.info("Student has entered ");
//                    return;
//                case 3:
//                    resp.sendRedirect(req.getContextPath() + "/dekanat");
//                    logger.info("Dekanat has entered ");
//                    return;
//            }
//        } catch (IOException e) {
//            logger.error("Error: "+ e.getMessage());
//            e.printStackTrace();
//        }

         }  else{
            try {
                resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authError");
            } catch (IOException e) {
                logger.error("Error: "+ e.getMessage());
                e.printStackTrace();
            }
        }

    }


    public void doGetAuth(HttpServletRequest req, HttpServletResponse resp){
                String action = req.getParameter("action");
        if("logout".equals(action)){
            req.getSession().invalidate();//выходим юзером после регистрации
            logger.info(req.getSession().getAttribute("login") + " завершение");
        }
        req.setAttribute("message","hello, my dear friend! ");
        try {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        } catch (ServletException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
    }

}
