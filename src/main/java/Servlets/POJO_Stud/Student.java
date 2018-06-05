package Servlets.POJO_Stud;

public class Student {
    private int id_student;
    private String name;
    private String last_name;
    private String schedule;
    private String home_work;
    private int course;


    public Student() {

    }

    public Student(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public Student(int id_student, String name, String last_name, int course) {
        this.id_student = id_student;
        this.name = name;
        this.last_name = last_name;
        this.course = course;
    }

    public Student(int id_student, String name, String last_name, String schedule, String home_work) {
        this.id_student = id_student;
        this.name = name;
        this.last_name = last_name;
        this.schedule = schedule;
        this.home_work = home_work;

    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getHome_work() {
        return home_work;
    }

    public void setHome_work(String home_work) {
        this.home_work = home_work;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", course=" + course +
                '}';
    }
}