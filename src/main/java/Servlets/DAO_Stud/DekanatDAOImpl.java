package Servlets.DAO_Stud;




import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Dekanat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DekanatDAOImpl implements  UserDAO<Dekanat> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Dekanat getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "SELECT  * FROM dekanat  WHERE  id_dekanat= ?");
        statement.setInt(1,id);

        ResultSet resultSet = statement.executeQuery();
        Dekanat dekanat = null;
        if(resultSet.next()){
            dekanat = new Dekanat(
                    resultSet.getInt("id_dekanat"),
                    resultSet.getInt("id_professor"),
                    resultSet.getInt("id_student"),
                    resultSet.getInt("point")
//                    resultSet.getInt("courseStudent"),
//                    resultSet.getDouble("grantStudent")
            );
        }
        connection.close();
        return dekanat;
    }

    @Override
    public void update(Dekanat dekanat) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "UPDATE  dekanat SET  id_professor=?," +
                        "id_student=?, point=?" +
                        " WHERE  id_dekanat=?");//добить с ади студента


        statement.setInt(1,dekanat.getId_Professor());
        statement.setInt(2,dekanat.getId_Student());
        statement.setInt(3,dekanat.getPointExam());

        int r = statement.executeUpdate();
        System.out.println(r+ " records update");

        connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

//         дописать
//        if(!)
        statement = connection.prepareStatement(
                "DELETE FROM  dekanat   WHERE  id_dekanat= ?");

        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println("Deleted");
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

    public List<Dekanat> getCourseStudent(){
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ArrayList<Dekanat> listCourse = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT  name, last_name  FROM student ");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Dekanat dekanat = new Dekanat();
                dekanat.setId_Student(resultSet.getInt("id_student"));
                dekanat.setCourseStudent(resultSet.getInt("course"));// возможно не id , a id_student мб в базе данных

                listCourse.add(dekanat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listCourse;
    }

}