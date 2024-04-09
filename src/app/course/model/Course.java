package app.course.model;

public class Course {

    private int id;
    private String name;
    private String department;
    private int profesorId;

    public Course(int id, String name, String department, int profesorId){
        this.id = id;
        this.name = name;
        this.department = department;
        this.profesorId = profesorId;
    }

    public Course(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
        this.department = tokens[2];
        this.profesorId = Integer.parseInt(tokens[3]);

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getProfesorId() {return this.profesorId;}
    public void setProfesorId(int profesorId) {this.profesorId = profesorId;}

    public String descriere(){

        String text = "";
        text+= "Name: " + this.name + "\n";
        text += "Department: " + this.department + "\n";

        return text;

    }

}
