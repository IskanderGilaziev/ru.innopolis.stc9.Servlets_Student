package Servlets.DAO_Stud;




import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Dekanat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DekanatDAOImpl implements  UserDAO<Dekanat> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Dekanat getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

//        statement = connection.prepareStatement(
//                "SELECT  * FROM dekanat  WHERE  id_dekanat= ?");

//        ResultSet resultSet = statement.executeQuery();
//        Dekanat dekanat = null;
//        if(resultSet.next()){
//            dekanat = new Dekanat(
//                    resultSet.getInt("idDekanat"),
//                    resultSet.getInt("pointStudentTest"),
//                    resultSet.getInt("pointStudentExam"),
//                    resultSet.getInt("courseStudent"),
//                    resultSet.getDouble("grantStudent"),
//                    resultSet.getBoolean("deducation"),
//                    resultSet.getString("schedule"),
//
//            );
//        }
        connection.close();
        return null; //dekanat;
    }

    @Override
    public void update(Dekanat dekanat) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;

//        statement = connection.prepareStatement(
//                "UPDATE  dekanat SET points_student_test =?, points_student_exam=?," +
//                        "course_students=?, grant_student=?, deducation =?, schedule = ?" +
//                        " WHERE  id=?");//добить с ади студента


//        statement.setInt(1,dekanat.getPointStudentTest());
//        statement.setInt(2,dekanat.getPointStudentExam());
//        statement.setInt(3,dekanat.getCourseStudent());
//        statement.setDouble(4,dekanat.getGrantStudent());
//        statement.setBoolean(5,dekanat.isDeducation());
//        statement.setString(6,dekanat.getSchedule());

        int r = statement.executeUpdate();
        System.out.println(r+ " records update");

        connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        // дописать
       // if(!)
//        statement = connection.prepareStatement(
//                "DELETE FROM  dekanat   WHERE  id= ?");
//
//        statement.setInt(1,id);
//        statement.executeUpdate();
//        System.out.println("Deleted");
        connection.close();

        return  true;
    }

    @Override
    public void add(Dekanat dekanat) throws SQLException {

    }

    @Override
    public Dekanat getByLogin(String login) {
        return null;
    }
}
