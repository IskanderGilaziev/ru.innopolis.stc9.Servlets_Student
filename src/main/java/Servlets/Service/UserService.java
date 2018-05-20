package Servlets.Service;


import Servlets.DAO_Stud.UserDAO;
import Servlets.DAO_Stud.UserDaoImpl;
import Servlets.POJO_Stud.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService {
    private  static UserDAO userDAO = new UserDaoImpl();

    public boolean checkAuthorisation(String login, String password){
        User user = (User) userDAO.getByLogin(login);
        return (user != null) && (user.getPassword().equals(password));
    }

    public int getRole (String login){
        User user = (User) userDAO.getByLogin(login);
        return  user.getRole();
    }


    public void doPostAuth(HttpServletRequest req, HttpServletResponse resp) {

        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        UserService userService = new UserService();
         if(userService.checkAuthorisation(login,password)){
        // String login1="professor";
        //      if((login1.equals(login)) && (login1.equals(password))){
        Integer role = userService.getRole(login);//получаем роль при прохождении регистрации
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("role",role);
        try {
            switch (role) {
                case 1:
                    resp.sendRedirect(req.getContextPath() + "/professor/dashboard");
                    return;
                case 2:
                    resp.sendRedirect(req.getContextPath() + "/student/dashboard");
                    return;
                case 3:
                    resp.sendRedirect(req.getContextPath() + "/dekanat/dashboard");
                    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         }  else{
            try {
                resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authError");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void doGetAuth(HttpServletRequest req, HttpServletResponse resp){
                String action = req.getParameter("action");
        if("logout".equals(action)){
            req.getSession().invalidate();//выходим юзером после регистрации
        }
        req.setAttribute("message","hello, my dear friend! ");
        try {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
