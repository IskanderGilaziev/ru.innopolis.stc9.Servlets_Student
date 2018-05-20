package Servlets.Service;



import Servlets.DAO_Stud.StudentDAOImpl;
import Servlets.POJO_Stud.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private  static   StudentDAOImpl studentDAO = new StudentDAOImpl();

    public List<Student> getStudentsByID(int id){
        try {
            return (List<Student>) studentDAO.getByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public ArrayList getNameStudent(){
        ArrayList<Student> studentName = null;
        try {
            studentName = studentDAO.getNameStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentName;
    }
}
