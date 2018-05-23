package Servlets.Service;

import Servlets.DAO_Stud.ProfessorDAOImpl;
import Servlets.POJO_Stud.Professor;
import Servlets.POJO_Stud.Student;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService {

    private  static ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();

    public Professor getProfessorByID(int id){
            return  professorDAO.getByID(id);
    }


    public List getAllProfessor(){
       ArrayList<Professor> professors = (ArrayList<Professor>) professorDAO.getAllProfessor();
        return professors;
    }
}
