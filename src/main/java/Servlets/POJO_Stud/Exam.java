package Servlets.POJO_Stud;

public class Exam {
    private int idExam;
    private String titleExam;
    private  String answerExam;
    private String questionExam;
    private  String answerStudent;
    private boolean endedLesson;

    private int idEducationProcess;


    public int getIdExam() {
        return idExam;
    }

    public Exam(String titleExam, String questionExam) {
        this.titleExam = titleExam;
        this.questionExam = questionExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public String getTitleExam() {
        return titleExam;
    }

    public void setTitleExam(String titleExam) {
        this.titleExam = titleExam;
    }

    public String getAnswerExam() {
        return answerExam;
    }

    public void setAnswerExam(String answerExam) {
        this.answerExam = answerExam;
    }

    public String getQuestionExam() {
        return questionExam;
    }

    public void setQuestionExam(String questionExam) {
        this.questionExam = questionExam;
    }

    public String getAnswerStudent() {
        return answerStudent;
    }

    public void setAnswerStudent(String answerStudent) {
        this.answerStudent = answerStudent;
    }

    public boolean isEndedLesson() {
        return endedLesson;
    }

    public void setEndedLesson(boolean endedLesson) {
        this.endedLesson = endedLesson;
    }

    public int getIdEducationProcess() {
        return idEducationProcess;
    }

    public void setIdEducationProcess(int idEducationProcess) {
        this.idEducationProcess = idEducationProcess;
    }


}
