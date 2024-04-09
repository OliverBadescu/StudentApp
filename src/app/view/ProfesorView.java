package app.view;

import app.book.service.BookService;
import app.course.model.Course;
import app.course.service.CourseService;
import app.enrolment.service.EnrolmentService;
import app.profesor.model.Profesor;
import app.profesor.service.ProfesorService;
import app.student.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfesorView {

    private ProfesorService profesorService;
    private Profesor profesor;
    private StudentService studentService;
    private EnrolmentService enrolmentService;
    private BookService bookService;
    private CourseService courseService;
    private Scanner scanner;

    public ProfesorView(Profesor profesor){

        this.profesor = profesor;
        this.profesorService = new ProfesorService();
        this.studentService = new StudentService();
        this.bookService = new BookService();
        this.enrolmentService = new EnrolmentService();
        this.courseService = new CourseService();
        this.scanner = new Scanner(System.in);

        this.play();

    }


    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa nr de cursuri predate");
        System.out.println("Apasati tasta 2 pentru a adauga un curs");
        System.out.println("Apasati tasta 3 pentru a sterge un curs");
        System.out.println("Apasati tasta 4 pentru a edita un curs");
        System.out.println("Apasati tasta 5 pentru a afisa cursurile predate de dvs.");
        System.out.println("Apasati tasta 6 pentru a afisa cel mai popular curs al dvs.");

        System.out.println("\n");
        System.out.println("Apasati tasta 10 pentru a iesi din aplicatie");
    }


    private void play() {

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {

                case 1:
                    afisareNrCursuriPredate();
                    break;
                case 2:
                    adaugareCurs();
                    break;
                case 3:
                    stergereCurs();
                    break;
                case 4:
                    editareCurs();
                    break;
                case 5:
                    listaCursuri();
                    break;
                case 6:
                    afisareCelMaiPopularCurs();
                    break;
                case 10:
                    running = false;
                    break;

                default:
                    System.out.println("Tasta incorecta");
                    break;
            }
        }
    }

    private void afisareNrCursuriPredate(){

        int nrC = this.profesor.getNrCursuri();

        System.out.println("Predati " + nrC + " cursuri");

    }

    private void adaugareCurs() {

        System.out.println("Introduceti numele cursului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti departamentul cursului: ");
        String department = scanner.nextLine();

        Course nou = new Course(courseService.generateId(), nume, department, this.profesor.getId());

        if (courseService.addCourse(nou)) {
            System.out.println("Cursul a fost adaugat");
            this.profesor.setNrCursuri(this.profesor.getNrCursuri() + 1);
        } else {
            System.out.println("Cursul deja exista");
        }

    }

    private void stergereCurs(){

        System.out.println("Introduceti numele cursului: ");
        String nume = scanner.nextLine();

        Course nou = courseService.findByName(nume);

        if(nou.getProfesorId() == this.profesor.getId()) {
            if (enrolmentService.areEleveiInscrisi(nou)) {
                if (courseService.stergereCourse(nou)) {
                    System.out.println("Cursul a fost sters");
                }else{
                    System.out.println("Cursul nu a fost gasit");
                }
            } else {
                System.out.println("Cursul are studenti inscrisi");
            }
        }else{
            System.out.println("Cursul nu este predat de dvs.");
        }

    }

    private void editareCurs(){

        System.out.println("Introduceti numele cursului care doriti sa il editati: ");
        String nume = scanner.nextLine();

        Course curs = courseService.findByName(nume);

        if(curs.getProfesorId() == this.profesor.getId()){
            System.out.println("Ce doriti sa editati?");
            System.out.println("1. Nume");
            System.out.println("2. Departament");

            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    System.out.println("Introduceti noul nume: ");
                    String nume2 = scanner.nextLine();
                    curs.setName(nume2);
                    break;
                case 2:
                    System.out.println("Introduceti noul departament: ");
                    String departament = scanner.nextLine();
                    curs.setDepartment(departament);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }else{
            System.out.println("Cursul nu este predat de dvs.");
        }

    }

    private void listaCursuri(){

        ArrayList<Course> list = new ArrayList<>(courseService.listaCursuriProf(this.profesor.getId()));

        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i).descriere());
        }

    }

    private void sortareDupaEnrolments(){

        ArrayList<Course> courses = courseService.getCourses();

        boolean sortat = false;
        do{
            sortat = true;

            for(int i=0;i<courses.size()-1;i++){
                if(enrolmentService.nrEnrolments(courses.get(i)) < enrolmentService.nrEnrolments(courses.get(i+1))){
                    Course aux = courses.get(i);
                    courses.set(i,courses.get(i+1));
                    courses.set(i+1,aux);
                    sortat = false;

                }
            }
        }while(!sortat);

    }

    private void afisareCelMaiPopularCurs(){

        ArrayList<Course> courses = courseService.getCourses();
        sortareDupaEnrolments();

        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getProfesorId() == this.profesor.getId()){
                System.out.println(courses.get(i).descriere());
                break;
            }
        }

    }
}
