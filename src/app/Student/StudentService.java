package app.Student;
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students;

    public StudentService(){

        this.students = new ArrayList<>();
        this.loadData();

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findStudentById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    private Student findStudentById(int id){
        for (int i =0; i < students.size();i++){
            if(students.get(i).getId() == id){
                return students.get(i);
            }
        }
        return null;
    }

    private void loadData(){

        Student s1 = new Student(1, "Alex" ,"Stoica", "alexstoica@gmail.com", 18, "password1");
        Student s2 = new Student(2, "Maria", "Popescu", "mariapopescu@gmail.com", 20, "password2");
        Student s3 = new Student(3,"Ion", "Ionescu", "ionionescu@gmail.com", 22, "password3");
        Student s4 = new Student(4, "Elena", "Georgescu", "elenageorgescu@gmail.com", 19, "password4");
        Student s5 = new Student(5,"Andrei", "Mihai", "andreimihai@gmail.com", 21, "password5");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    public void afisareStudents(){

        for (int i =0 ; i < students.size();i++){
            System.out.println(students.get(i).descriere());
        }

    }

}
