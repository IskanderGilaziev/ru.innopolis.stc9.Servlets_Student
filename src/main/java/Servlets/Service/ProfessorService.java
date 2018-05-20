package Servlets.Service;

import Servlets.DAO_Stud.ProfessorDAOImpl;
import Servlets.POJO_Stud.Professor;
import Servlets.POJO_Stud.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    private  static ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();

    public List<Professor> getProfessorByID(int id){
        try {
            return (List<Professor>) professorDAO.getByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public ArrayList getNameProfessor(){
        ArrayList<String> professorName = new ArrayList<>();
        try {
            professorName = professorDAO.getNameProfessor();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professorName;
    }
}
