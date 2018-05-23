package Servlets.Service;



import Servlets.DAO_Stud.StudentDAOImpl;
import Servlets.POJO_Stud.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    private  static StudentDAOImpl studentDAO = new StudentDAOImpl();

    public Student getStudentsByID(int id){
       return studentDAO.getByID(id);
    }


    public ArrayList<Student> getNameStudent(){
        return studentDAO.getNameStudent();
    }
}
