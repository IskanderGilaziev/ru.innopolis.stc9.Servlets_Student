package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements UserDAO<Student> {
    private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Student getByID(int id) {
        Connection connection = connectionManager.getConnection();
        Student student1 = null;
        try{
        PreparedStatement statement =  connection.prepareStatement(
                "SELECT  * FROM student  WHERE  id_student= ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            student1 = new Student(
                    resultSet.getInt("id_student"),
                    resultSet.getString("name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("course")

            );
        }
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return student1;
    }

    @Override
    public void update(Student student)  {
        Connection connection = connectionManager.getConnection();
        try{
        PreparedStatement statement =  connection.prepareStatement(
                "UPDATE  student SET name = ?,last_name=? WHERE  id_student=?");

        statement.setString(1, student.getName());
        statement.setString(2, student.getLast_name());
        int r = statement.executeUpdate();
        System.out.println(r + " records update");
        connection.close();

    } catch (SQLException e) {
        logger.error("Error: "+ e.getMessage());
        e.printStackTrace();
        }
    }

    @Override
    public boolean deleteByID(int id) {
        Connection connection = connectionManager.getConnection();
       try{
        PreparedStatement statement =  connection.prepareStatement(
                "DELETE FROM  student   WHERE  id_student= ?");

        statement.setInt(1, id);
        statement.executeUpdate();
        System.out.println("Deleted");
        connection.close();
    } catch (SQLException e) {
        logger.error("Error: "+ e.getMessage());
        e.printStackTrace();
    }
        return true;
    }

    @Override
    public void add(Student student){
        Connection connection = connectionManager.getConnection();
      try{
        PreparedStatement statement =  connection.prepareStatement(
                "INSERT  INTO  " +
                        "student(id_student,name,last_name,course)" +
                        "VALUES  (?,?,?,?)");

        statement.setInt(1, student.getId_student());
        statement.setString(2, student.getName());
        statement.setString(3, student.getLast_name());
       statement.setInt(4,student.getCourse());

        statement.executeUpdate();
        connection.close();
      } catch (SQLException e) {
          logger.error("Error: "+ e.getMessage());
          e.printStackTrace();
      }
    }

    @Override
    public Student getByLogin(String login) {
        return null;
    }


    public ArrayList<Student> getNameStudent()  {
        Connection connection = connectionManager.getConnection();
        ArrayList<Student> listNameStudent = new ArrayList<>();
        try{
        PreparedStatement statement =  connection.prepareStatement(
                "SELECT  name, last_name  FROM student ");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();
            student.setId_student(resultSet.getInt("id"));// возможно не id , a id_student мб в базе данных
            student.setName(resultSet.getString("name"));
            student.setLast_name(resultSet.getString("last_name"));
            listNameStudent.add(student);
        }
            connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return listNameStudent;
    }


    public List<Student> getAllStudent(){
        Connection connection = connectionManager.getConnection();
        ArrayList<Student> students = new ArrayList<>();
        Student student = null;
        try{
        PreparedStatement statement =  connection.prepareStatement(
                "SELECT  * FROM student");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            student = new Student(
                    resultSet.getInt("id_student"),
                    resultSet.getString("name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("course"));
            students.add(student);
        }
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return students;
    }
}
