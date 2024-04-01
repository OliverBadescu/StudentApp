package app.Course;

public class Course {

    private int id;
    private String name;
    private String department;

    public Course(int id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
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

    public String descriere(){

        String text = "";
        text += "Id: " + this.id + "\n";
        text+= "Name: " + this.name + "\n";
        text += "Department: " + this.department + "\n";

        return text;

    }

}
