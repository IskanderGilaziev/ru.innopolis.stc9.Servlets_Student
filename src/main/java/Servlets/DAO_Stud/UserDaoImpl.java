package Servlets.DAO_Stud;



import Servlets.ConnectionManager.ConnectionManagerJDBCImpl;
import Servlets.POJO_Stud.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements  UserDAO<User> {
    @Override
    public User getByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public boolean deleteByID(int id) throws SQLException {
        return false;
    }

    @Override
    public void add(User user) throws SQLException {

    }

    @Override
    public User getByLogin(String login) {

        User result = null;
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT *  FROM  user_login WHERE  login =?");

            statement.setString(1,login);// возможно удалить
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                result = new User(
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("role"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
