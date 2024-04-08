package app.Admin;
import java.util.ArrayList;
public class AdminService {

    private ArrayList<Admin> admins;

    public AdminService() {

        this.admins = new ArrayList<>();
        this.loadData();

    }

    private void loadData() {

        Admin a1 = new Admin("Oliver", "123");

        this.admins.add(a1);

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
