package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAOImpl implements  UserDAO<Professor> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Professor getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "SELECT  * FROM professor  WHERE  id_professor= ?");

        ResultSet resultSet = statement.executeQuery();
        Professor professor = null;
//        if(resultSet.next()){
//            professor = new Professor(
//                    resultSet.getInt("idProfessor"),
//                    resultSet.getString("name"),
//                    resultSet.getString("lastName"),
//                    resultSet.getString("homeWork"),
//                    resultSet.getInt("idEducationProcess")
//
//            );
       // }
       // connection.close();
        return null; //professor;
    }

    @Override
    public void update(Professor professor) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "UPDATE  professor SET home_work=? WHERE  id=?");

        statement.setString(1,professor.getHomeWork());
        int r = statement.executeUpdate();
        System.out.println(r + " records update");

        connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "DELETE FROM  professor   WHERE  id= ?");

        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println("Deleted");
        connection.close();

        return  true;
    }

    @Override
    public void add(Professor professor) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;


        statement = connection.prepareStatement(
                "INSERT  INTO  " +
                        "professor(id_professor,name,last_name,home_work, id_education_process)" +
                        "VALUES  (?,?,?,?,?)");

        statement.setInt(1,professor.getIdProfessor());
        statement.setString(2,professor.getName());
        statement.setString(3,professor.getLastName());
        statement.setString(4,professor.getHomeWork());
       // statement.setInt(5,professor.getIdEducationProcess());

        statement.executeUpdate();
        connection.close();
    }

    @Override
    public Professor getByLogin(String login) {
        return null;
    }
}
