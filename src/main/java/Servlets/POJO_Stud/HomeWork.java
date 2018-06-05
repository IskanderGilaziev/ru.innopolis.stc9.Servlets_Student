package Servlets.POJO_Stud;

public class HomeWork {
    private int id;
    private String homeWork;
    private int id_professor;

    public HomeWork(String homeWork, int id_professor) {
        this.homeWork = homeWork;
        this.id_professor = id_professor;
    }

    public HomeWork(int id, String homeWork, int id_professor) {
        this.id = id;
        this.homeWork = homeWork;
        this.id_professor = id_professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
}
