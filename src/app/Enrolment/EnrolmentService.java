package app.Enrolment;

import app.Course.Course;

import java.util.ArrayList;

public class EnrolmentService {

    private ArrayList<Enrolment> enrolments;

    public EnrolmentService(){

        this.enrolments = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Enrolment e1 = new Enrolment(1, 20);
        Enrolment e2 = new Enrolment(2, 20);
        Enrolment e3 = new Enrolment(3, 20);
        Enrolment e4 = new Enrolment(4, 23);
        Enrolment e5 = new Enrolment(5, 23);

        enrolments.add(e1);
        enrolments.add(e2);
        enrolments.add(e3);
        enrolments.add(e4);
        enrolments.add(e5);


    }

    public void newEnrolment(int studentId, int courseId){

        Enrolment enrolment = new Enrolment(studentId,courseId);

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
