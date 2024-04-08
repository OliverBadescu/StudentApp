package app.Profesor;

import app.Admin.Admin;
import app.Course.Course;

import java.util.ArrayList;

public class ProfesorService {

    private ArrayList<Profesor> profesors;

    public ProfesorService() {
        profesors = new ArrayList<>();
        this.loadData();
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findProfesorById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Profesor findProfesorById(int id){
        for (int i =0; i < profesors.size();i++){
            if(profesors.get(i).getId() == id){
                return profesors.get(i);
            }
        }
        return null;

    }


    private void loadData() {

        Profesor p1= new Profesor(100, "Dana", "Simian", "password1", 1);
        Profesor p2 = new Profesor(101, "John", "Doe", "password2",1 );
        Profesor p3 = new Profesor(102, "Alice", "Smith", "password3", 1);
        Profesor p4 = new Profesor(103, "Robert", "Johnson", "password4", 1);
        Profesor p5 = new Profesor(104, "Emily", "Brown", "password5", 1);

        profesors.add(p1);
        profesors.add(p2);
        profesors.add(p3);
        profesors.add(p4);
        profesors.add(p5);


    }

    public Profesor findByname(String nume, String prenume){

        for (int i =0 ; i < profesors.size();i++){
            if(profesors.get(i).getNume().equals(nume) && profesors.get(i).getPrenume().equals(prenume)){
                return profesors.get(i);
            }
        }
        return null;
    }

    public Profesor login(String nume, String password) {

        for( int i = 0 ; i< this.profesors.size() ; i++){
            if(profesors.get(i).getNume().equals(nume) && profesors.get(i).getPassword().equals(password)){
                return this.profesors.get(i);
            }
        }
        return null;
    }


}
