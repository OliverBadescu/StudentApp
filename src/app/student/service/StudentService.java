package app.student.service;
import app.profesor.model.Profesor;
import app.student.model.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

    public Student findStudentById(int id){
        for (int i =0; i < students.size();i++){
            if(students.get(i).getId() == id){
                return students.get(i);
            }
        }
        return null;
    }

    private void loadData(){


        try{
            String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\profesor\\data\\profesors.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Student student = new Student(line);

                this.students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afisareStudents(){

        for (int i =0 ; i < students.size();i++){
            System.out.println(students.get(i).descriere());
        }

    }

    public Student logare(String email, String password){

        for(int i =0 ; i < students.size();i++){
            if(students.get(i).getEmail().equals(email)  && students.get(i).getPassword().equals(password)){
                return students.get(i);
            }
        }
        return null;
    }

    public boolean inregistrare(Student student){
        for(int i =0; i < students.size();i++){
            if(students.get(i).getEmail().equals(student.getEmail())){
                return false;
            }
        }
        this.students.add(student);
        return true;
    }

    public boolean stergereStudent(Student student){
        for (int i =0 ; i < students.size();i++){
            if(students.get(i).getId() == student.getId()){
                this.students.remove(student);
                return true;
            }
        }
        return false;
    }





}
