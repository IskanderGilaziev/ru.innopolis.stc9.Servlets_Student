package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAOImpl implements  UserDAO<Professor> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Professor getByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "SELECT  * FROM professor  WHERE  id_professor= ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Professor professor = null;
        if(resultSet.next()){
            professor = new Professor(
                    resultSet.getInt("id_professor"),
                    resultSet.getString("name"),
                    resultSet.getString("last_Name")
                   // resultSet.getString("homeWork")
            );
        }
        connection.close();
        return  professor;
    }

    @Override
    public void update(Professor professor) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "UPDATE  professor SET name=? WHERE  id=?");

        statement.setString(1,professor.getName());
        int r = statement.executeUpdate();
        System.out.println(r + " records update");

        connection.close();
    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "DELETE FROM  professor   WHERE  id_professor= ?");

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
                        "professor(id_professor,name,last_name)" +
                        "VALUES  (?,?,?)");

        statement.setInt(1,professor.getIdProfessor());
        statement.setString(2,professor.getName());
        statement.setString(3,professor.getLastName());
//        statement.setString(4,professor.getHomeWork());


        statement.executeUpdate();
        connection.close();
    }

    @Override
    public Professor getByLogin(String login) {
        return null;
    }


    public ArrayList<String> getNameProfessor() throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        statement = connection.prepareStatement(
                "SELECT  name  FROM professor ");

        ResultSet resultSet = statement.executeQuery();
        ArrayList<String> listNameProfessor = new ArrayList<>();
        if(resultSet.next()){
                listNameProfessor.add(resultSet.getString("name"));
        }
        connection.close();
        return listNameProfessor;
    }
}
