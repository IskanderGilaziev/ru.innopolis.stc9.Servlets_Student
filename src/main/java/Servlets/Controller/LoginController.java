package Servlets.Controller;



import Servlets.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
   private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if("logout".equals(action)){
            req.getSession().invalidate();//выходим юзером после регистрации
        }
        req.setAttribute("message","hello");
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");

        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");

   // if(userService.checkAuthorisation(login,password)){
        if(("user".equals(login)) && ("password".equals(password))){
            Integer role = userService.getRole(login);//плучаем роль при прохождении регистрации
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("role",role);
        if(role==1){
            resp.sendRedirect(req.getContextPath()+"/admin/dashboard");
        }else{
            resp.sendRedirect(req.getContextPath()+"/user/dashboard");
        }

    }
    else{
         resp.sendRedirect(req.getContextPath()+"/login?errorMsg=authError");
    }
    }
}