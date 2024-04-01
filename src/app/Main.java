package app;

import app.Student.Student;

public class Main {
    public static void main(String[] args) {
          Student s1 = new Student(1, "Alex" ,"Stoica", "alexstoica@gmail.com", 18, "password1");
            StudentView studentView = new StudentView(s1);
    }
}