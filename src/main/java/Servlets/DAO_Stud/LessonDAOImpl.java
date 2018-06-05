package Servlets.DAO_Stud;

import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Lesson;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDAOImpl implements LessonDAO {
    private static Logger logger = Logger.getLogger(HomeWorkDAOImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public boolean addLesson(Lesson lesson) {
        if (lesson == null)
            return false;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO lesson(id,id_student,id_professor,theme,on_lesson) " +
                            "VALUES (?,?,?,?,?)");
            statement.setInt(1, lesson.getId());
            statement.setInt(2, lesson.getId_student());
            statement.setInt(3, lesson.getId_professor());
            statement.setString(4, lesson.getTheme());
            statement.setBoolean(5, lesson.isLesson());
            statement.executeUpdate();
            connection.close();
            logger.info("add lesson");

        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteLesson(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM lesson WHERE  id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
            logger.info("delete lesson by ID");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Lesson> getAllLesson() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM lesson");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lesson lesson = new Lesson(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_professor"),
                        resultSet.getString("theme"),
                        resultSet.getBoolean("on_lesson"));
                lessons.add(lesson);
            }
            connection.close();
            logger.info("get all lesson");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
        return lessons;
    }

    @Override
    public void update(Lesson lesson) {
        if (lesson == null) {
            return;
        }
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE lesson SET theme=?,on_lesson=?, id_student=?, id_professor=?" +
                            " WHERE  id=?");
            statement.setString(1, lesson.getTheme());
            statement.setBoolean(2, lesson.isLesson());
            statement.setInt(3, lesson.getId_student());
            statement.setInt(4, lesson.getId_professor());
            statement.executeUpdate();
            connection.close();
            logger.info("update lesson");

        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    @Override
    public Lesson getLessonById(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM lesson WHERE  id=?");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lesson lesson = new Lesson(
                        resultSet.getInt("id_student"),
                        resultSet.getInt("id_professor"),
                        resultSet.getString("theme"),
                        resultSet.getBoolean("on_lesson"));
                connection.close();
                return lesson;
            }
            logger.info("get  lesson by ID");
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
        return null;
    }
}
