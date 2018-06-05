package Servlets.Service;

import Servlets.DAO_Stud.LessonDAO;
import Servlets.DAO_Stud.LessonDAOImpl;
import Servlets.POJO_Stud.Lesson;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    private LessonDAO lessonDAO = new LessonDAOImpl();

    @Override
    public boolean addLesson(Lesson lesson) {
        return lessonDAO.addLesson(lesson);
    }

    @Override
    public boolean deleteLesson(int id) {
        return lessonDAO.deleteLesson(id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonDAO.getAllLesson();
    }

    @Override
    public void update(Lesson lesson) {
        lessonDAO.update(lesson);
    }

    @Override
    public Lesson getLessonById(int id) {
        return lessonDAO.getLessonById(id);
    }
}
