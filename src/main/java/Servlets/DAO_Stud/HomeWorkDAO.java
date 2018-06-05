package Servlets.DAO_Stud;

import Servlets.POJO_Stud.HomeWork;

import java.util.List;

public interface HomeWorkDAO {
    void update(HomeWork homeWork);

    boolean addHomeWork(HomeWork homeWork);

    boolean deleteHomeWork(int id);

    List<HomeWork> getAllHomeWork();

    List<HomeWork> getProfessorHomeWork();

    HomeWork getHomeWorkById(int id);
}
