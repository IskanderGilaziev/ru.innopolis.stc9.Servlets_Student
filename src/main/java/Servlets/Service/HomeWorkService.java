package Servlets.Service;

import Servlets.POJO_Stud.HomeWork;

import java.util.List;

public interface HomeWorkService {
    void update(HomeWork homeWork);

    boolean addHomeWork(HomeWork homeWork);

    boolean deleteHomeWork(int id);

    List<HomeWork> getAllHomeWork();

    List<HomeWork> getProfessorHomeWork();

    HomeWork getHomeWorkById(int id);
}
