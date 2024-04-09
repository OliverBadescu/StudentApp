package app.view;

import app.admin.model.Admin;
import app.admin.service.AdminService;
import app.book.service.BookService;
import app.course.model.Course;
import app.course.service.CourseService;
import app.enrolment.service.EnrolmentService;
import app.profesor.model.Profesor;
import app.profesor.service.ProfesorService;
import app.student.model.Student;
import app.student.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private AdminService adminService;
    private StudentService studentService;
    private EnrolmentService enrolmentService;
    private BookService bookService;
    private CourseService courseService;
    private Scanner scanner;
    private Admin admin;
    private ProfesorService profesorService;

    public AdminView(Admin admin) {

        this.admin = admin;
        this.adminService = new AdminService();
        this.studentService = new StudentService();
        this.bookService = new BookService();
        this.enrolmentService = new EnrolmentService();
        this.courseService = new CourseService();
        this.profesorService = new ProfesorService();
        this.scanner = new Scanner(System.in);


        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a adauga un curs");
        System.out.println("Apasati tasta 2 pentru a sterge un curs");
        System.out.println("Apasati tasta 3 pentru a edita un curs");
        System.out.println("Apasati tasta 4 pentru a afisa studentii");
        System.out.println("Apasati tasta 5 pentru a sterge un student");
        System.out.println("Apasati tasta 6 pentru a afisa cel mai popular curs");
        System.out.println("Apasati tasta 7 pentru a afisa cursurile fara studenti");
        System.out.println("Apasati tasta 8 pentru a edita datele unui student");
        System.out.println("Apasati tasta 9 pentru a sorta cursurile dupa nr. de inscrieri");
        System.out.println("Apasati tasta 10 pentru a afisa cursurile");
        System.out.println("Apasati tasta 11 pentru a va deloga");
        System.out.println("Apasati tasta 12 pentru a afisa admini");





    }

    private void play(){

        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){

                case 1:
                    adaugareCurs();
                    break;
                case 2:
                    stergereCurs();
                    break;
                case 3:
                    editareCurs();
                    break;
                case 4:
                    studentService.afisareStudents();
                    break;
                case 5:
                    stergereStudent();
                    break;
                case 6:
                    afisareCursPopular();
                    break;
                case 7:
                    afisareCursFaraStudenti();
                    break;
                case 8:
                    editareStudent();
                    break;
                case 9:
                    sortareDupaEnrolments();
                    break;
                case 10:
                    courseService.afisareCourses();
                    break;
                case 11:
                    running = false;
                    break;
                case 12:
                    adminService.afisareAdmin();
                    break;
                default:
                    System.out.println("Tasta incorecta");

            }

        }

    }

    private void adaugareCurs(){

        System.out.println("Introduceti numele cursului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti departamentul cursului: ");
        String department = scanner.nextLine();
        System.out.println("Introduceti numele profesorului care preda acest curs: ");
        System.out.println("Nume: ");
        String numeProf = scanner.nextLine();
        System.out.println("Prenume: ");
        String prenume = scanner.nextLine();

        Profesor prof = profesorService.findByname(numeProf, prenume);


        if(prof!=null) {
            Course nou = new Course(courseService.generateId(), nume, department, prof.getId());
            if (courseService.addCourse(nou)) {
                System.out.println("Cursul a fost adaugat");
                prof.setNrCursuri(prof.getNrCursuri()+ 1);
            } else {
                System.out.println("Cursul deja exista");
            }
        }else{
            System.out.println("Profesorul nu exista");
        }


    }

    private void stergereCurs(){

        System.out.println("Introduceti numele cursului: ");
        String nume = scanner.nextLine();

        Course nou = courseService.findByName(nume);
        if(nou!=null) {
            if (enrolmentService.areEleveiInscrisi(nou)) {
                if (courseService.stergereCourse(nou)) {
                    System.out.println("Cursul a fost sters");
                }
            }else {
                System.out.println("Cursul are studenti inscrisi");
            }
        }
        else{
            System.out.println("Cursul nu exista");
        }
    }

    private void stergereStudent() {
        System.out.println("Introduceti id-ul studentului: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = studentService.findStudentById(id);
        if (student != null) {
            if (studentService.stergereStudent(student)) {
                System.out.println("Studentul a fost sters");
            }
        }else{
            System.out.println("Student nu a fost gasit");
        }
    }

    private void afisareCursPopular(){

        int curs = enrolmentService.celMaiPopularCurs();
        Course course = courseService.findCourseById(curs);

        System.out.println(course.descriere());


    }

    private void afisareCursFaraStudenti(){

        ArrayList<Integer> list = enrolmentService.cursuriFaraStudenti();
        ArrayList<Course> courseList = new ArrayList<>(courseService.courseList(list));
        for (int i =0 ; i<courseList.size();i++){
            System.out.println(courseList.get(i).descriere());
        }

    }

    private void editareCurs(){

        System.out.println("Introduceti numele cursului care doriti sa il editati: ");
        String nume = scanner.nextLine();

        Course curs = courseService.findByName(nume);

        if(curs != null){
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
            System.out.println("Cursul nu a fost gasit");
        }

    }

    private void editareStudent(){
        System.out.println("Introduceti id-ul studentului: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.findStudentById(id);

        if(student!= null){

            System.out.println("Ce doriti sa editati?");
            System.out.println("1. First name");
            System.out.println("2. Last name");
            System.out.println("3. Email");
            System.out.println("4. Password");
            System.out.println("5. Age");

            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    System.out.println("New first name: ");
                    String firstName = scanner.nextLine();
                    student.setFirstName(firstName);
                    break;
                case 2:
                    System.out.println("New last name: ");
                    String lastName = scanner.nextLine();
                    student.setLastName(lastName);
                    break;
                case 3:
                    System.out.println("New email: ");
                    String email = scanner.nextLine();
                    student.setEmail(email);
                    break;
                case 4:
                    System.out.println("New password: ");
                    String password = scanner.nextLine();
                    student.setPassword(password);
                    break;
                case 5:
                    System.out.println("New age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    student.setAge(age);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }else{
            System.out.println("Studentul nu a fost gasit");
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

}
