package app.course.service;

import app.course.model.Course;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseService {

    private ArrayList<Course> courses;

    public CourseService(){
        this.courses = new ArrayList<>();
        this.loadData();

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findCourseById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Course findCourseById(int id){
        for (int i =0; i < courses.size();i++){
            if(courses.get(i).getId() == id){
                return courses.get(i);
            }
        }
        return null;

    }


    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\course\\data\\courses.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Course course = new Course(line);

                this.courses.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void afisareCourses(){

        for (int i =0 ; i < courses.size();i++){
            System.out.println(courses.get(i).descriere());
        }

    }

    public Course findByName(String name){

        for(int i =0 ; i < courses.size(); i++){
            if(courses.get(i).getName().equals(name)){
                return courses.get(i);
            }
        }
        return null;
    }

    public ArrayList<Course> courseList(ArrayList<Integer> courseIds){

        ArrayList<Course> courseList = new ArrayList<>();

        for (int i =0; i < courses.size();i++){
            if(courseIds.contains(courses.get(i).getId())){
                courseList.add(courses.get(i));
            }
        }
        return courseList;
    }

    public boolean addCourse(Course course){

        for(int i =0 ; i < courses.size(); i++){
            if(courses.get(i).getName().equals(course.getName())){
                return false;
            }
        }
        this.courses.add(course);
        return true;
    }

    public boolean stergereCourse(Course course){

        for(int i =0 ; i < courses.size(); i++){
            if(courses.get(i).getName().equals(course.getName())){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public ArrayList<Course> listaCursuriProf(int profId){

        ArrayList<Course> courseList = new ArrayList<>();

        for(int i =0 ; i < courses.size(); i++){
            if(courses.get(i).getProfesorId() == profId){
                courseList.add(courses.get(i));
            }
        }
        return courseList;
    }


}
