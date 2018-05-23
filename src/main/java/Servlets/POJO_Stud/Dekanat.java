package Servlets.POJO_Stud;

public class Dekanat {
    private int id_Dekanat;
    private int id_Professor;
    private int id_Student;
    private int PointExam;
    private int courseStudent;
    private double grantStudent;
   // private boolean deducation = false;
  //  private String schedule;


    public Dekanat(int id_Professor, int id_Student, int pointExam) {
        this.id_Professor = id_Professor;
        this.id_Student = id_Student;
        PointExam = pointExam;
    }

    public Dekanat(int id_Dekanat, int id_Professor, int id_Student, int pointExam) {
        this.id_Dekanat = id_Dekanat;
        this.id_Professor = id_Professor;
        this.id_Student = id_Student;
        PointExam = pointExam;
    }

    public Dekanat(int id_Dekanat, int id_Professor, int id_Student, int pointExam, int courseStudent, double grantStudent) {
        this.id_Dekanat = id_Dekanat;
        this.id_Professor = id_Professor;
        this.id_Student = id_Student;
        PointExam = pointExam;
        this.courseStudent = courseStudent;
        this.grantStudent = grantStudent;
    }

    public Dekanat() {

    }

    public int getId_Dekanat() {
        return id_Dekanat;
    }

    public void setId_Dekanat(int id_Dekanat) {
        this.id_Dekanat = id_Dekanat;
    }

    public int getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.id_Professor = id_Professor;
    }

    public int getId_Student() {
        return id_Student;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    public int getPointExam() {
        return PointExam;
    }

    public void setPointExam(int pointExam) {
        PointExam = pointExam;
    }

    public int getCourseStudent() {
        return courseStudent;
    }

    public void setCourseStudent(int courseStudent) {
        this.courseStudent = courseStudent;
    }

    public double getGrantStudent() {
        return grantStudent;
    }

    public void setGrantStudent(double grantStudent) {
        this.grantStudent = grantStudent;
    }
}