package app.Student;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;

    public Student(int id, String firstName, String lastName, String email, int age, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public int getId(){return this.id;};
    public void setId(int id){this.id = id;}
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String descriere(){

        String text = "";

        text += "Id: " + this.id + "\n";
        text+= "First name: " + this.firstName + "\n";
        text += "Last name: " + this.lastName + "\n";
        text += "Email: " + this.email + "\n";
        text += "Password: " + this.password + "\n";
        text += "Age: " + this.age + "\n";

        return text;

    }

}
