package app.Enrolment;

public class Enrolment {

    private int studentId;
    private int courseId;

    public Enrolment(int studentId, int courseId){
        this.studentId = studentId;
        this.courseId = courseId;
    }

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
