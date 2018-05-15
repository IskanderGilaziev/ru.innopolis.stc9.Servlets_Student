package Servlets.DAO_Stud;

import java.sql.SQLException;

public interface TestExamDAO<T> {
    public  void addTE(T t) throws SQLException;
    public boolean delete(int id) throws SQLException;
    public  void update(T t) throws SQLException;
    public T getTE(int id) throws SQLException;
}
