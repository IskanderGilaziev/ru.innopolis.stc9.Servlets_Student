package Servlets.Service;

import Servlets.DAO_Stud.ProfessorDAOImpl;
import Servlets.POJO_Stud.Professor;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {
    private static Logger logger = Logger.getLogger(ProfessorServiceImpl.class);
    private static ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();

    @Override
    public Professor getProfessorByID(int id) {
        return professorDAO.getByID(id);
    }

    @Override
    public List<Professor> getAllProfessor() {
        ArrayList<Professor> professors = (ArrayList<Professor>) professorDAO.getAllProfessor();
        return professors;
    }

    @Override
    public void updateProfessor(Professor professor) {
        try {
            professorDAO.update(professor);
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteProfessorByID(int id) {
        return professorDAO.deleteByID(id);
    }

    @Override
    public void addProfessor(Professor professor) {
        professorDAO.add(professor);
    }

    @Override
    public Professor getByLoginProfessor(String login) {
        return professorDAO.getByLogin(login);
    }
}
