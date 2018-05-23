package Servlets.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImpl implements  ConnectionManager {
    //синглтон реализуем
    private  static  ConnectionManager connectionManager;

    public  static  ConnectionManager getInstance(){
        if(connectionManager == null){
             connectionManager = new ConnectionManagerJDBCImpl();
        }
        return  connectionManager;//метод статичен и не нужно его
        //возвращаем один экземпляр
    }

    public ConnectionManagerJDBCImpl(){

    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/student_achiev",
                    "postgres",
                    "116"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
