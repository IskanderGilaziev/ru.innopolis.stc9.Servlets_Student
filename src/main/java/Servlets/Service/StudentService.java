package Servlets.Service;

import Servlets.POJO_Stud.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    Student getStudentsByID(int id);

    ArrayList<Student> getNameStudent();

    void updateStudent(Student student);

    boolean deleteStudentByID(int id);

    void addStudent(Student professor);

    Student getByLoginStudent(String login);

    List<Student> getAllStudent();
}
