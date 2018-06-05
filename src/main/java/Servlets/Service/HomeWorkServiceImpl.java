package Servlets.Service;

import Servlets.DAO_Stud.HomeWorkDAO;
import Servlets.DAO_Stud.HomeWorkDAOImpl;
import Servlets.POJO_Stud.HomeWork;

import java.util.List;

public class HomeWorkServiceImpl implements HomeWorkService {
    private HomeWorkDAO homeWorkDAO = new HomeWorkDAOImpl();

    @Override
    public void update(HomeWork homeWork) {
        homeWorkDAO.update(homeWork);
    }

    @Override
    public boolean addHomeWork(HomeWork homeWork) {
        return homeWorkDAO.addHomeWork(homeWork);
    }

    @Override
    public boolean deleteHomeWork(int id) {
        return homeWorkDAO.deleteHomeWork(id);
    }

    @Override
    public List<HomeWork> getAllHomeWork() {
        return homeWorkDAO.getAllHomeWork();
    }

    @Override
    public List<HomeWork> getProfessorHomeWork() {
        return homeWorkDAO.getProfessorHomeWork();
    }

    @Override
    public HomeWork getHomeWorkById(int id) {
        return homeWorkDAO.getHomeWorkById(id);
    }
}
