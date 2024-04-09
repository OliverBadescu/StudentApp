package app.profesor.service;

import app.enrolment.model.Enrolment;
import app.profesor.model.Profesor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\profesor\\data\\profesors.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Profesor profesor = new Profesor(line);

                this.profesors.add(profesor);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
