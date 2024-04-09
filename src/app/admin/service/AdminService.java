package app.admin.service;
import app.admin.model.Admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    private ArrayList<Admin> admins;

    public AdminService() {

        this.admins = new ArrayList<>();
        this.loadData();

    }

    private void loadData() {


        try{
           String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\admin\\data\\admins";
           File file = new File(filePath);
           Scanner sc = new Scanner(file);
           while (sc.hasNextLine()) {

               String line = sc.nextLine();

               Admin admin = new Admin(line);

               this.admins.add(admin);
           }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisareAdmin(){
        for(int i =0 ; i < this.admins.size() ; i++){
            System.out.println(admins.get(i).descriere());
        }
    }

    public Admin login(String username, String password) {

        for( int i = 0 ; i< this.admins.size() ; i++){
            if(admins.get(i).getName().equals(username) && admins.get(i).getPassword().equals(password)){
                return this.admins.get(i);
            }
        }
        return null;
    }


}
