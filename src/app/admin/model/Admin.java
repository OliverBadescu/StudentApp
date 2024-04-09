package app.admin.model;

public class Admin {

    private int id;
    private String name;
    private String password;

    public Admin(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Admin(String text) {

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
        this.password = tokens[2];

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}


    public String descriere(){

        String txt = "";
        txt+= "Id: " + this.id + "\n";
        txt+= "Name: " + this.name + "\n";
        txt+= "Password: " + this.password + "\n";

        return txt;

    }
}
