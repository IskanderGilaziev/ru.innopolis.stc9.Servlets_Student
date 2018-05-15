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
            PreparedStatement statement = connection.prepareStatement("SELECT *  FROM  users WHERE  login =?");
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                result = new User(resultSet.getInt("id"),resultSet.getString("login"),
                        resultSet.getString("passwordHash"),resultSet.getInt("role"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
