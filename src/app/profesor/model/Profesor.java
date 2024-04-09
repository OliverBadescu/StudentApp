package app.profesor.model;

public class Profesor {

    private int id;
    private String nume;
    private String prenume;
    private String password;
    private int nrCursuri;

    public Profesor(int id, String nume, String prenume, String password, int nrCursuri) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.password = password;
        this.nrCursuri = nrCursuri;
    }

    public Profesor(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.nume = tokens[1];
        this.prenume = tokens[2];
        this.password = tokens[3];
        this.nrCursuri = Integer.parseInt(tokens[4]);

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNume() {return nume;}
    public void setNume(String nume) {this.nume = nume;}
    public String getPrenume() {return prenume;}
    public void setPrenume(String prenume) {this.prenume = prenume;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public int getNrCursuri() {return nrCursuri;}
    public void setNrCursuri(int nrCursuri) {this.nrCursuri = nrCursuri;}

    public String descriere(){

        String text = "";
        text += "Id: " + this.id + "\n";
        text += "Nume: " + this.nume + "\n";
        text += "Prenume: " + this.prenume + "\n";
        text += "Password: " + this.password + "\n";

        return text;
    }

}
