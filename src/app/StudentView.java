package app;
import app.Book.Book;
import app.Book.BookService;
import app.Course.Course;
import app.Course.CourseService;
import app.Enrolment.EnrolmentService;
import app.Student.Student;
import app.Student.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {

        private StudentService studentService;
        private EnrolmentService enrolmentService;
        private BookService bookService;
        private CourseService courseService;
        private Scanner scanner;
        private Student student;
        public StudentView(Student student){

            this.student = student;
            this.studentService = new StudentService();
            this.bookService = new BookService();
            this.enrolmentService = new EnrolmentService();
            this.courseService = new CourseService();
            this.scanner = new Scanner(System.in);

            this.play();

        }


        private void meniu(){

            System.out.println("Apasati tasta 1 pentru a afisa cursurile disponibile");
            System.out.println("Apasati tasta 2 pentru a inrola la un curs");
            System.out.println("Apasati tasta 3 pentru a afisa la ce cursuri sunteti inscris");
            System.out.println("Apasati tasta 4 pentru a renunta la un curs");
            System.out.println("Apasati tasta 5 pentru a afisa datele personale");


        }

        private void play(){

            boolean running = true;

            while(running ){
                meniu();
                int alegere = Integer.parseInt(scanner.nextLine());

                switch (alegere){
                    case 1:
                        courseService.afisareCourses();
                        break;
                    case 2:
                        enrolmentCourse();
                        break;
                    case 3:
                        afisareEnrolments();
                        break;
                    case 4:
                        quitEnrolments();
                        break;
                    case 5:
                        System.out.println(this.student.descriere());
                        break;
                    default:
                        System.out.println("Tasta incorecta");

                }
            }

        }

        private void enrolmentCourse(){

            System.out.println("Introduceti numele cursului la care doriti sa va inscrieti: ");
            String name = scanner.nextLine();

            Course course = courseService.findByName(name);

            if (course!= null){
                if(!enrolmentService.isInscrisLaCurs(this.student.getId(), course.getId())) {
                    System.out.println("V-ati inscris cu succes la curs!");
                    enrolmentService.newEnrolment(student.getId(), course.getId());
                }else{
                    System.out.println("Sunteti deja inscris la acest curs");
                }
            }else{
                System.out.println("Cursul nu exista");
            }

        }

        private void afisareEnrolments(){

            ArrayList<Integer> list = new ArrayList<>(enrolmentService.enrolmentsStudent(this.student.getId()));
            ArrayList<Course> courseList = new ArrayList<>(courseService.courseList(list));

            for (int i =0 ; i<courseList.size();i++){
                System.out.println(courseList.get(i).descriere());
            }

        }

        private void quitEnrolments(){

            System.out.println("Introduceti numele cursului la care doriti sa renuntati: ");
            String name = scanner.nextLine();

            Course course = courseService.findByName(name);

            if (course!= null){
                if(enrolmentService.isInscrisLaCurs(this.student.getId(), course.getId())){
                    System.out.println("Ati renuntat la curs");
                }else{
                    System.out.println("Nu sunteti inscris la acest curs");
                }
            }else{
                System.out.println("Cursul nu exista");
            }


        }
}
