package app.Course;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses;

    public CourseService(){
        this.courses = new ArrayList<>();
        this.loadData();

    }


    private void loadData(){

        Course c1 = new Course(20, "OOP", "Informatica");
        Course c2 = new Course(21, "Contabilitate", "Economie");
        Course c3 = new Course(22, "Algoritmi fundamentali", "Informatica");
        Course c4 = new Course(23, "Algebra", "Matematica");
        Course c5 = new Course(24, "Tehinici avansate de programare", "Informatica");

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
}
