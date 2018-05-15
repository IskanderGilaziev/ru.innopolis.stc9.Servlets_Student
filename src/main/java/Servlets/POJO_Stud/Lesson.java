package Servlets.POJO_Stud;

import java.util.Date;

public class Lesson {
    private int idLesson;
    private  String titleLesson;
    private boolean attendance;
    private Date endLesson;
    private  int idStudent;
    private  Student student;

    public Lesson(int idLesson, String titleLesson, boolean attendance, Date endLesson, int idStudent) {
        this.idLesson = idLesson;
        this.titleLesson = titleLesson;
        this.attendance = attendance;
        this.endLesson = endLesson;
        this.idStudent = idStudent;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getTitleLesson() {
        return titleLesson;
    }

    public void setTitleLesson(String titleLesson) {
        this.titleLesson = titleLesson;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public Date getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(Date endLesson) {
        this.endLesson = endLesson;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson(int idLesson, String titleLesson, boolean attendance, Date endLesson, int idStudent, Student student) {

        this.idLesson = idLesson;
        this.titleLesson = titleLesson;
        this.attendance = attendance;
        this.endLesson = endLesson;
        this.idStudent = idStudent;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "idLesson=" + idLesson +
                ", titleLesson='" + titleLesson + " " +
                ", attendance=" + attendance +
                ", idStudent=" + idStudent + ';';
    }
}
