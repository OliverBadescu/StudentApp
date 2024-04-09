package app.enrolment.model;

public class Enrolment {

    private int id;
    private int studentId;
    private int courseId;

    public Enrolment(int id, int studentId, int courseId){
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Enrolment(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.studentId = Integer.parseInt(tokens[1]);
        this.courseId = Integer.parseInt(tokens[2]);

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getStudentId() {
        return this.studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getCourseId() {
        return this.courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


}
