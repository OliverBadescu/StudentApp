package app.Enrolment;

import java.util.ArrayList;

public class EnrolmentService {

    private ArrayList<Enrolment> enrolments;

    public EnrolmentService(){

        this.enrolments = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Enrolment e1 = new Enrolment(1, 20);
        Enrolment e2 = new Enrolment(2, 21);
        Enrolment e3 = new Enrolment(3, 22);
        Enrolment e4 = new Enrolment(4, 23);
        Enrolment e5 = new Enrolment(5, 24);

        enrolments.add(e1);
        enrolments.add(e2);
        enrolments.add(e3);
        enrolments.add(e4);
        enrolments.add(e5);


    }

    public void afisareEnrolments(){

        for (int i =0 ;i<  enrolments.size() ;i++){
            System.out.println(enrolments.get(i).descriere());
        }

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

    public boolean isInscrisLaCurs(int studentId, int courseId){

        for (int i =0 ; i < enrolments.size();i++){
            if(enrolments.get(i).getStudentId() == studentId && enrolments.get(i).getCourseId() == courseId){
                this.enrolments.remove(enrolments.get(i));
                return true;
            }
        }
        return false;
    }
}
