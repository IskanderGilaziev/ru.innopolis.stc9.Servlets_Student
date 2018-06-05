package Servlets.Service;


import Servlets.DAO_Stud.StudentDAOImpl;
import Servlets.POJO_Stud.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Override
    public Student getStudentsByID(int id) {
        return studentDAO.getByID(id);
    }

    @Override
    public ArrayList<Student> getNameStudent() {
        return studentDAO.getNameStudent();
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    @Override
    public boolean deleteStudentByID(int id) {
        return studentDAO.deleteByID(id);
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.add(student);
    }

    @Override
    public Student getByLoginStudent(String login) {
        return studentDAO.getByLogin(login);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }
}
