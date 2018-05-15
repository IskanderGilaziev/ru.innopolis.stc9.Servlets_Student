package Servlets.POJO_Stud;

public class Dekanat {
    private int id_Dekanat;
    private int pointStudentTest;
    private  int PointStudentExam;
    private  int courseStudent;
    private  double grantStudent;
    private  boolean deducation = false;
    private  String schedule;



    public Dekanat(int id_Dekanat, int pointStudentTest, int PointStudentExam, int courseStudent, double grantStudent, boolean deducation, String schedule) {
        this.id_Dekanat = id_Dekanat;
        this.pointStudentTest = pointStudentTest;
        this.PointStudentExam = PointStudentExam;
        this.courseStudent = courseStudent;
        this.grantStudent = grantStudent;
        this.deducation = deducation;
        this.schedule = schedule;

    }



    public int getId_Dekanat() {
        return id_Dekanat;
    }

    public void setId_Dekanat(int id_Dekanat) {
        this.id_Dekanat = id_Dekanat;
    }

    public int getPointStudentTest() {
        return pointStudentTest;
    }

    public void setPointStudentTest(int pointStudentTest) {
        this.pointStudentTest = pointStudentTest;
    }

    public int getPointStudentExam() {
        return PointStudentExam;
    }

    public void setGetPointStudentExam(int getPointStudentExam) {
        this.PointStudentExam = PointStudentExam;
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

    public boolean isDeducation() {
        return deducation;
    }

    public void setDeducation(boolean deducation) {
        this.deducation = deducation;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
