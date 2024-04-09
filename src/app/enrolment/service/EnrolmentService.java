package app.enrolment.service;

import app.course.model.Course;
import app.enrolment.model.Enrolment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EnrolmentService {

    private ArrayList<Enrolment> enrolments;

    public EnrolmentService(){

        this.enrolments = new ArrayList<>();
        this.loadData();
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findEnrolmentById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Enrolment findEnrolmentById(int id){
        for (int i =0; i < enrolments.size();i++){
            if(enrolments.get(i).getId() == id){
                return enrolments.get(i);
            }
        }
        return null;

    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\enrolment\\data\\enrolments.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Enrolment enrolment = new Enrolment(line);

                this.enrolments.add(enrolment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void newEnrolment(int studentId, int courseId){

        Enrolment enrolment = new Enrolment(generateId(), studentId,courseId);

        enrolments.add(enrolment);

    }


    public ArrayList<Integer> enrolmentsStudent(int id){

        ArrayList<Integer> enrolmentsStudent = new ArrayList<>();

        for (int i =0 ; i < enrolments.size();i++){
            if(enrolments.get(i).getStudentId() == id){
                enrolmentsStudent.add(enrolments.get(i).getCourseId());
            }
        }
        return enrolmentsStudent;
    }

    public boolean isInscrisLaCursRemove(int studentId, int courseId){

        for (int i =0 ; i < enrolments.size();i++){
            if(enrolments.get(i).getStudentId() == studentId && enrolments.get(i).getCourseId() == courseId){
                this.enrolments.remove(enrolments.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean isInscrisLaCurs(int studentId, int courseId){

        for (int i =0 ; i < enrolments.size();i++){
            if(enrolments.get(i).getStudentId() == studentId && enrolments.get(i).getCourseId() == courseId){
                return true;
            }
        }
        return false;
    }

    public int celMaiPopularCurs(){

        int[] cursFrecventa = new int[100];

        for(int i =0 ; i < enrolments.size(); i++){
            cursFrecventa[enrolments.get(i).getCourseId()]++;
        }

        int max =0;
        int curs = 0;
        for(int i =0; i < cursFrecventa.length; i++){
            if(cursFrecventa[i] > max){
                max = cursFrecventa[i];
                curs = i;
            }
        }
        return curs;
    }

    public ArrayList<Integer> cursuriFaraStudenti(){

        ArrayList<Integer> cursuriFaraStudenti = new ArrayList<>();

        int[] cursFrecventa = new int[100];
        for(int i =0 ; i < enrolments.size(); i++){
            cursFrecventa[enrolments.get(i).getCourseId()]++;
        }

        for (int i =0; i  < cursFrecventa.length; i++){
            if(cursFrecventa[i] == 0){
                cursuriFaraStudenti.add(i);
            }
        }
        return cursuriFaraStudenti;
    }

    public boolean areEleveiInscrisi(Course course){
        for(int i =0 ; i < enrolments.size(); i++){
            if(enrolments.get(i).getCourseId() == course.getId()){
                return false;
            }
        }
        return true;
    }

    public int nrEnrolments(Course course){

        int ct = 0;
        for(int i =0 ; i < enrolments.size(); i++){
            if(enrolments.get(i).getCourseId() == course.getId()){
                ct++;
            }
        }
        return ct;
    }



}
