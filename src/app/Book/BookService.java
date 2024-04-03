package app.Book;


import java.util.ArrayList;

public class BookService {

    private ArrayList<Book> books;

    public BookService(){
        this.books = new ArrayList<>();
        this.loadData();

    }

    private void loadData(){

        Book b1 = new Book(30, 1, "Bazele Programari");
        Book b2 = new Book(31, 2, "Algebra Liniara");
        Book b3 = new Book(32, 3, "Oriented-Object Programming");
        Book b4 = new Book(33, 4, "Fundamentele C#");
        Book b5 = new Book(34, 5, "Dictionar Engleza");

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);

    }

    public void afisareBooks(){

        for (int i =0 ; i < books.size();i++){
            System.out.println(books.get(i).descriere());
        }

    }

    public Book BookStudent(int idStudent){

        for (int i =0; i < books.size();i++){

            if(books.get(i).getStudentId() == idStudent){
                return books.get(i);
            }

        }
        return null;
    }

    public Book findBookbyName(String bookName){

        for (int i =0 ; i < books.size();i++){
            if(books.get(i).getBookName().equals(bookName)){
                return books.get(i);
            }
        }
        return null;
    }
}
