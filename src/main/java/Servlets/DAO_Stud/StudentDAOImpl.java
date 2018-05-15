package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements UserDAO<Student> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    //или можно все  таки List использовать?
    public Student getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

            statement = connection.prepareStatement(
                    "SELECT  * FROM student  WHERE  id_students= ?");

            ResultSet resultSet = statement.executeQuery();
            Student student1 = null;
            if(resultSet.next()){
                student1 = new Student(
                        resultSet.getInt("idStudent"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("schedule"),
                        resultSet.getString("homeWork")
              //          resultSet.getInt("idProgressStudent")
                );
            }
            connection.close();
            return  student1;
    }

    @Override
    public void update(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();

        //как быть с id_student ?
        PreparedStatement statement = null;

            statement = connection.prepareStatement(
                    "UPDATE  student SET schedule = ?,home_work=? WHERE  id=?");

            //что за нумерация параметраИндекса?
            statement.setString(1,student.getSchedule());
            statement.setString(2,student.getHome_work());
           int r = statement.executeUpdate();
            System.out.println(r+ " records update");

             connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

            statement = connection.prepareStatement(
                    "DELETE FROM  student   WHERE  id= ?");

            statement.setInt(1,id);
            statement.executeUpdate();
        System.out.println("Deleted");
            connection.close();

        return  true;
    }

    @Override
    public void add(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;


            statement = connection.prepareStatement(
                    "INSERT  INTO  " +
                            "student(id_students,name,last_name,home_work, schedule,id_progress_student)" +
                            "VALUES  (?,?,?,?,?,?)");

            statement.setInt(1,student.getId_student());
            statement.setString(2,student.getName());
            statement.setString(3,student.getLast_name());
            statement.setString(4,student.getHome_work());
            statement.setString(5,student.getSchedule());

            //получает это на совести БД?
           // statement.setInt(6,student.getIdProgressStudent());

            statement.executeUpdate();
            connection.close();
    }

    @Override
    public Student getByLogin(String login) {
        return null;
    }
}
