package Servlets.Service;

import Servlets.POJO_Stud.Lesson;

import java.util.List;

public interface LessonService {
    boolean addLesson(Lesson lesson);

    boolean deleteLesson(int id);

    List<Lesson> getAllLesson();

    void update(Lesson lesson);

    Lesson getLessonById(int id);
}
