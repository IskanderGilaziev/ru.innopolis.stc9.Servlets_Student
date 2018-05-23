package Servlets.DAO_Stud;




import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Dekanat;
import Servlets.POJO_Stud.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DekanatDAOImpl implements  UserDAO<Dekanat> {
    private static Logger logger = Logger.getLogger(DekanatDAOImpl.class);
    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Dekanat getByID(int id)  {
        Connection connection = connectionManager.getConnection();
        Dekanat dekanat = null;
       try {
           PreparedStatement statement = connection.prepareStatement(
                   "SELECT  * FROM dekanat  WHERE  id_dekanat= ?");
           statement.setInt(1, id);

           ResultSet resultSet = statement.executeQuery();

           if (resultSet.next()) {
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
       }catch(SQLException e){
           logger.error("Error: "+ e.getMessage());
           e.printStackTrace();
       }
        return dekanat;
    }

    @Override
    public void update(Dekanat dekanat) {
        Connection connection = connectionManager.getConnection();
        try {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE  dekanat SET  id_professor=?," +
                        "id_student=?, point=?" +
                        " WHERE  id_dekanat=?");//добить с ади студента


        statement.setInt(1,dekanat.getId_Professor());
        statement.setInt(2,dekanat.getId_Student());
        statement.setInt(3,dekanat.getPointExam());

        int r = statement.executeUpdate();
        System.out.println(r+ " records update");
        connection.close();

        }catch(SQLException e){
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteByID(int id)  {
        Connection connection = connectionManager.getConnection();
        try{
        PreparedStatement statement =  connection.prepareStatement(
                "DELETE FROM  dekanat   WHERE  id_dekanat= ?");

        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println("Deleted");
        connection.close();
        }catch(SQLException e){
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
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
        ArrayList<Dekanat> listCourse = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
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