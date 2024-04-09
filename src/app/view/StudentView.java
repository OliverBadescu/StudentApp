package app.view;
import app.book.model.Book;
import app.book.service.BookService;
import app.course.model.Course;
import app.course.service.CourseService;
import app.enrolment.service.EnrolmentService;
import app.student.model.Student;
import app.student.service.StudentService;

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
            System.out.println("Apasati tasta 5 pentru a afisa cartea dvs.");
            System.out.println("Apasati tasta 6 pentru a sterge cartea dvs.");
            System.out.println("Apasati tasta 7 pentru a adauga o carte");
            System.out.println("Apasati tasta 8 cartea dvs.");
            System.out.println("Apasati tasta 9 pentru a afisa cartile");
            System.out.println("Apasati tasta 10 pentru a cauta o carte");
            System.out.println("Apasati tasta 11 pentru a afisa datele personale");
            System.out.println("Apasati tasta 12 pentru a edita datele personale");
            System.out.println("\n");
            System.out.println("Apasati tasta 13 pentru a iesi din cont");

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
                        afisareBookStudent();
                        break;
                    case 6:
                        stergereCarte();
                        break;
                    case 7:
                        adaugareCarte();
                        break;
                    case 8:
                        editareCarte();
                        break;
                    case 9:
                        bookService.afisareBooks();
                        break;
                    case 10:
                        cautareBook();
                        break;
                    case 11:
                        System.out.println(this.student.descriere());
                        break;
                    case 12:
                        editareDate();
                        break;
                    case 13:
                        running = false;
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
                if(enrolmentService.isInscrisLaCursRemove(this.student.getId(), course.getId())){
                    System.out.println("Ati renuntat la curs");
                }else{
                    System.out.println("Nu sunteti inscris la acest curs");
                }
            }else{
                System.out.println("Cursul nu exista");
            }


        }

        private void afisareBookStudent(){

            Book book = bookService.BookStudent(this.student.getId());
            if(book!= null) {
                System.out.println(book.descriere());
            }else{
                System.out.println("Nu aveti nici-o carte");
            }

        }

        private void cautareBook(){
            System.out.println("Ce carte cautati?");
            String name = scanner.nextLine();

            Book book = bookService.findBookbyName(name);

            if(book != null){
                System.out.println("Cartea se afla la studentul: ");
                System.out.println(studentService.findStudentById(book.getStudentId()).descriere());
            }else{
                System.out.println("Nici un student nu are aceasta carte");
            }
        }

        private void editareDate(){

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
                    this.student.setFirstName(firstName);
                    break;
                case 2:
                    System.out.println("New last name: ");
                    String lastName = scanner.nextLine();
                    this.student.setLastName(lastName);
                    break;
                case 3:
                    System.out.println("New email: ");
                    String email = scanner.nextLine();
                    this.student.setEmail(email);
                    break;
                case 4:
                    System.out.println("New password: ");
                    String password = scanner.nextLine();
                    this.student.setPassword(password);
                    break;
                case 5:
                    System.out.println("New age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    this.student.setAge(age);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }


        }

        private void stergereCarte(){

            System.out.println("Introduceti numele cartii dvs.");
            String name = scanner.nextLine();

            Book book = bookService.findBookbyName(name);

            if(book != null){
                if(bookService.stergereCarte(book, this.student.getId())){
                    System.out.println("Cartea dvs. a fost stearsa");
                }else{
                    System.out.println("Cartea introdusa nu se afla la dvs.");
                }
            }else{
                System.out.println("Cartea nu exista");
            }


        }

        private void adaugareCarte(){

            System.out.println("Introduceti numele cartii: ");
            String name = scanner.nextLine();

            Book book = new Book(bookService.generateId(), this.student.getId(), name);

            if (bookService.adaugareCarte(book, this.student.getId())) {
                System.out.println("Cartea a fost adaugata");

            } else {
                System.out.println("Cartea se afla deja la alt student");
            }

        }

        private void editareCarte(){

            Book book = bookService.findByStudentId(this.student.getId());

            System.out.println("Introduceti noul nume al cartii: ");
            String name = scanner.nextLine();
            book.setBookName(name);
        }
}
