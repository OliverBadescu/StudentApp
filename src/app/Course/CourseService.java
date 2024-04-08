package app.Course;

import java.util.ArrayList;

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

        Course c1 = new Course(20, "OOP", "Informatica", 100);
        Course c2 = new Course(21, "Contabilitate", "Economie", 101);
        Course c3 = new Course(22, "Algoritmi fundamentali", "Informatica" , 102);
        Course c4 = new Course(23, "Algebra", "Matematica", 103);
        Course c5 = new Course(24, "Tehinici avansate de programare", "Informatica", 104);

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);


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
