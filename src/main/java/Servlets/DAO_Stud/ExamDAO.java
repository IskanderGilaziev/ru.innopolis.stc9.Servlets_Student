package Servlets.DAO_Stud;





import Servlets.ConnectionManager.ConnectionManager;
import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDAO implements  TestExamDAO<Exam> {

    private  static ConnectionManager connectionManager =
            ConnectionManagerJDBCImpl.getInstance();

    @Override
    public void addTE(Exam exam) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public void update(Exam exam) throws SQLException {

    }

    @Override
    public Exam getTE(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        statement = connection.prepareStatement(
                "SELECT title_exam, qeustion_exam FROM exam ");

        ResultSet resultSet = statement.executeQuery();
        Exam  exam = null;
        if(resultSet.next()){
            exam = new Exam(
                    resultSet.getString("TitleExam"),
                    resultSet.getString("questionExam")
            );
        }
        connection.close();
        return exam;
    }
}
