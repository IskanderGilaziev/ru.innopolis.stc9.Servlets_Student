package Servlets.DAO_Stud;

import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.HomeWork;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkDAOImpl implements HomeWorkDAO {
    private static Logger logger = Logger.getLogger(HomeWorkDAOImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public void update(HomeWork homeWork) {
        if (homeWork == null) {
            return;
        }
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE home_work SET home_work_=?,id_professor=? WHERE  id=?");
            statement.setInt(1, homeWork.getId());
            statement.setString(2, homeWork.getHomeWork());
            statement.setInt(3, homeWork.getId_professor());
            statement.executeUpdate();
            connection.close();
            logger.info("update home_work");

        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean addHomeWork(HomeWork homeWork) {
        if (homeWork == null)
            return false;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO home_work(id,home_work_,id_professor) " +
                            "VALUES (?,?,?)");
            statement.setInt(1, homeWork.getId());
            statement.setString(2, homeWork.getHomeWork());
            statement.setInt(3, homeWork.getId_professor());
            statement.executeUpdate();
            connection.close();
            logger.info("add home_work");

        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteHomeWork(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM home_work WHERE  id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
            logger.info("delete home_work by ID");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<HomeWork> getAllHomeWork() {
        ArrayList<HomeWork> homeWorks = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM home_work");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HomeWork homeWork = new HomeWork(
                        resultSet.getInt("id"),
                        resultSet.getString("home_work"),
                        resultSet.getInt("professor_id"));
                homeWorks.add(homeWork);
            }
            connection.close();
            logger.info("get all home_work");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
        return homeWorks;
    }

    @Override
    public List<HomeWork> getProfessorHomeWork() {
        return null;
    }

    @Override
    public HomeWork getHomeWorkById(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM home_work WHERE  id=?");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HomeWork homeWork = new HomeWork(
                        resultSet.getInt("id"),
                        resultSet.getString("home_work"),
                        resultSet.getInt("professor_id"));
                connection.close();
                return homeWork;
            }
            logger.info("get  home_work by ID");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
        return null;
    }
}
