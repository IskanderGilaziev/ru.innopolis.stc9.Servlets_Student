package Servlets.DAO_Stud;



import java.sql.SQLException;

public interface UserDAO<T> {

    //методы для работы с таблицей студент

    public T getByID(int id) throws SQLException;
    public  void update(T t) throws SQLException;
    public boolean deleteByID(int id) throws SQLException;
    public  void add(T t) throws SQLException;
    public  T getByLogin(String login);

}
