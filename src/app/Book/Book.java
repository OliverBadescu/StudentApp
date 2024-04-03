package app.Book;

public class Book {

    private int id;
    private int studentId;
    private String bookName;

    public Book(int id, int studentId, String bookName){
        this.id = id;
        this.studentId = studentId;
        this.bookName = bookName;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentId() {
        return this.studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String descriere(){

        String text = "";
        text += "Book name: " + this.bookName + "\n";

        return text;


    }

}
