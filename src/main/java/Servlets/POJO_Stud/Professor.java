package Servlets.POJO_Stud;

public class Professor {
    private  int idProfessor;
    private  String name;
    private  String lastName;
    private  String homeWork;

    public Professor(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Professor(int idProfessor, String name, String lastName) {
        this.idProfessor = idProfessor;
        this.name = name;
        this.lastName = lastName;
    }

    public Professor(int idProfessor, String name, String lastName, String homeWork) {
        this.idProfessor = idProfessor;
        this.name = name;
        this.lastName = lastName;
        this.homeWork = homeWork;

    }



    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }




    @Override
    public String toString() {
        return "Professor" +
                "idProfessor=" + idProfessor +
                ", name='" + name + " " +
                ", lastName='" + lastName + " " +
                ", homeWork='" + homeWork + " " +
                ';';
    }
}
