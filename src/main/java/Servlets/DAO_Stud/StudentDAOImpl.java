package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements UserDAO<Student> {

    private static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Student getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "SELECT  * FROM student  WHERE  id_student= ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Student student1 = null;
        if (resultSet.next()) {
            student1 = new Student(
                    resultSet.getInt("id_student"),
                    resultSet.getString("name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("course")

            );
        }
        connection.close();
        return student1;
    }

    @Override
    public void update(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();


        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "UPDATE  student SET name = ?,last_name=? WHERE  id_student=?");

        statement.setString(1, student.getName());
        statement.setString(2, student.getLast_name());
        int r = statement.executeUpdate();
        System.out.println(r + " records update");

        connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "DELETE FROM  student   WHERE  id_student= ?");

        statement.setInt(1, id);
        statement.executeUpdate();
        System.out.println("Deleted");
        connection.close();

        return true;
    }

    @Override
    public void add(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;


        statement = connection.prepareStatement(
                "INSERT  INTO  " +
                        "student(id_student,name,last_name,course)" +
                        "VALUES  (?,?,?,?)");

        statement.setInt(1, student.getId_student());
        statement.setString(2, student.getName());
        statement.setString(3, student.getLast_name());
       statement.setInt(4,student.getCourse());

        statement.executeUpdate();
        connection.close();
    }

    @Override
    public Student getByLogin(String login) {
//        Connection connection = connectionManager.getConnection();
//        try {
//            PreparedStatement statement =connection.prepareStatement(
//                    "SELECT  *  FROM student WHERE ");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }


    public ArrayList<Student> getNameStudent() throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ArrayList<Student> listNameStudent = new ArrayList<>();
        statement = connection.prepareStatement(
                "SELECT  name, last_name  FROM student ");

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Student student = new Student();
            student.setId_student(resultSet.getInt("id"));// возможно не id , a id_student мб в базе данных
            student.setName(resultSet.getString("name"));
            student.setLast_name(resultSet.getString("last_name"));
            listNameStudent.add(student);
        }
        return listNameStudent;
    }
}
