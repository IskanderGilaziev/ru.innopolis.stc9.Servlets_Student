package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Professor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl implements  UserDAO<Professor> {
    private static Logger logger = Logger.getLogger(ProfessorDAOImpl.class);
    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public Professor getByID(int id) {
        Connection connection = connectionManager.getConnection();
        Professor professor = null;
        try{
        PreparedStatement statement = connection.prepareStatement(
                "SELECT  * FROM professor  WHERE  id_professor= ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            professor = new Professor(
                    resultSet.getInt("id_professor"),
                    resultSet.getString("name"),
                    resultSet.getString("last_Name")
            );
        }
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return  professor;
    }

    @Override
    public void update(Professor professor) throws SQLException {
        Connection connection = connectionManager.getConnection();
        try{
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE  professor SET name=? WHERE  id=?");

        statement.setString(1,professor.getName());
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
                "DELETE FROM  professor   WHERE  id_professor= ?");

        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println("Deleted");
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return  true;
    }

    @Override
    public void add(Professor professor)  {
        Connection connection = connectionManager.getConnection();
        try{
        PreparedStatement statement = connection.prepareStatement(
                "INSERT  INTO  " +
                        "professor(id_professor,name,last_name)" +
                        "VALUES  (?,?,?)");

        statement.setInt(1,professor.getIdProfessor());
        statement.setString(2,professor.getName());
        statement.setString(3,professor.getLastName());

        statement.executeUpdate();
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Professor getByLogin(String login) {
        return null;
    }


    public ArrayList<String> getNameProfessor() {
        Connection connection = connectionManager.getConnection();
        ArrayList<String> listNameProfessor = new ArrayList<>();
        try{
        PreparedStatement statement = connection.prepareStatement(
                "SELECT  name  FROM professor ");

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
                listNameProfessor.add(resultSet.getString("name"));
        }
        connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return listNameProfessor;
    }


    public List<Professor> getAllProfessor(){
        Connection connection = connectionManager.getConnection();
        List<Professor> professors = new ArrayList<>();
       Professor professor = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT  name  FROM professor ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                professor = new Professor(resultSet.getString("name"),
                                resultSet.getString("lsat_name"));
                professors.add(professor);
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return professors;

    }
}
