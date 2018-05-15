package Servlets.Service;


import Servlets.DAO_Stud.UserDAO;
import Servlets.DAO_Stud.UserDaoImpl;
import Servlets.POJO_Stud.User;

public class UserService {
    private  static UserDAO userDAO = new UserDaoImpl();

    public boolean checkAuthorisation(String login, String password){
        User user = null;
        user = (User) userDAO.getByLogin(login);
        return (user != null) && (user.getPasswordHash().equals(password));
    }

    public Integer getRole (String login){
        User user = null;
        user = (User) userDAO.getByLogin(login);
        return user.getRole();
    }
}
