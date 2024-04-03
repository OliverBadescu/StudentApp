package app;
import app.Student.Student;
import app.Student.StudentService;

import java.util.Scanner;
public class LoginView {

    private StudentService studentService;
    private Scanner scanner;

    public LoginView(){

        this.studentService = new StudentService();
        this.scanner = new Scanner(System.in);

        this.play();

    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
        System.out.println("Apasati tasta 3 pentru a iesi din aplicatie");

    }

    private void play() {

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    logare();
                    break;
                case 2:
                    inregistrare();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void logare(){

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

}
