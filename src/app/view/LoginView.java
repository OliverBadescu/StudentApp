package app.view;
import app.admin.model.Admin;
import app.admin.service.AdminService;
import app.profesor.model.Profesor;
import app.profesor.service.ProfesorService;
import app.student.model.Student;
import app.student.service.StudentService;

import java.util.Scanner;
public class LoginView {

    private AdminService adminService;
    private StudentService studentService;
    private ProfesorService profesorService;
    private Scanner scanner;

    public LoginView(){

        this.studentService = new StudentService();
        this.adminService = new AdminService();
        this.profesorService = new ProfesorService();
        this.scanner = new Scanner(System.in);

        this.play();

    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
        System.out.println("Apasati tasta 3 pentru a iesi din aplicatie");

        System.out.println(" \n");
        System.out.println("Apasati tasta 4 pentru a va loga ca admin");
        System.out.println("Apasati tasta 5 pentru a va loga ca profesor");
    }

    private void play() {

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    logareStudent();
                    break;
                case 2:
                    inregistrare();
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    logareAdmin();
                    break;
                case 5:
                    logareProfesor();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void logareStudent(){

        System.out.println("Introduceti emailul si parola");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Student logare = studentService.logare(email, parola);
        if(logare != null){
            StudentView studentView = new StudentView(logare);
        }else{
            System.out.println("Date incorecte");
        }

    }

    private void inregistrare(){
        System.out.println("Introduceti datele urmatoare:");
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Parola: ");
        String password = scanner.nextLine();
        int id = studentService.generateId();
        Student student = new Student(id, firstName, lastName, email, age, password);
        if(studentService.inregistrare(student)){
            System.out.println("V-ati inregistrat cu succes, logati-va pentru a continua");
        }else{
            System.out.println("Emailul este deja folosit");
        }
    }

    private void logareAdmin(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Admin logare  = adminService.login(nume, parola);

        if(logare!= null){
            AdminView adminView = new AdminView(logare);
        }else{
            System.out.println("Date incorecte");
        }

    }

    private void logareProfesor(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Profesor logare = profesorService.login(nume, parola);

        if(logare!= null){
            ProfesorView profesorView =  new ProfesorView(logare);
        }else{
            System.out.println("Date incorecte");
        }

    }

}
