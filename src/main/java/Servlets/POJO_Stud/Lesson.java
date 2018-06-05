package Servlets.POJO_Stud;

public class Lesson {
    private int id;
    private int id_student;
    private int id_professor;
    private String theme;
    private boolean isLesson;

    public Lesson(int id, int id_student, int id_professor, String theme, boolean isLesson) {
        this.id = id;
        this.id_student = id_student;
        this.id_professor = id_professor;
        this.theme = theme;
        this.isLesson = isLesson;
    }

    public Lesson(int id_student, int id_professor, String theme, boolean isLesson) {
        this.id_student = id_student;
        this.id_professor = id_professor;
        this.theme = theme;
        this.isLesson = isLesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isLesson() {
        return isLesson;
    }

    public void setLesson(boolean lesson) {
        isLesson = lesson;
    }
}
