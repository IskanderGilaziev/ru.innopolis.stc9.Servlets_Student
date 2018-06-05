package Servlets.Service;

import Servlets.POJO_Stud.Professor;

import java.util.List;

public interface ProfessorService {
    Professor getProfessorByID(int id);

    List<Professor> getAllProfessor();

    void updateProfessor(Professor professor);

    boolean deleteProfessorByID(int id);

    void addProfessor(Professor professor);

    Professor getByLoginProfessor(String login);
}
