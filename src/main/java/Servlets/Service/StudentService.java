package Servlets.Service;



import Servlets.DAO_Stud.StudentDAOImpl;
import Servlets.DAO_Stud.UserDAO;
import Servlets.POJO_Stud.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    UserDAO<Student> userDAO = new StudentDAOImpl();

    public List<Student> getStudentsByID(int id){
        try {
            return (List<Student>) userDAO.getByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
