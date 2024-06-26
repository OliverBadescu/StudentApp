package app.book.service;


import app.admin.model.Admin;
import app.book.model.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {

    private ArrayList<Book> books;

    public BookService(){
        this.books = new ArrayList<>();
        this.loadData();

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findBookById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Book findBookById(int id){
        for (int i =0; i < books.size();i++){
            if(books.get(i).getId() == id){
                return books.get(i);
            }
        }
        return null;

    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\Student\\src\\app\\book\\data\\books.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Book book = new Book(line);

                this.books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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

    public boolean stergereCarte(Book book, int studentId){

        for (int i =0 ; i < books.size();i++){
            if(books.get(i).getBookName().equals(book.getBookName()) && books.get(i).getStudentId() == studentId){
                this.books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean adaugareCarte(Book book, int studentId){

        for (int i =0 ; i < books.size();i++){
            if(books.get(i).getBookName().equals(book.getBookName())){
                return false;
            }
        }
        this.books.add(book);
        return true;
    }

    public Book findByStudentId(int studentId){
        for (int i =0 ; i < books.size();i++){
            if(books.get(i).getStudentId() == studentId){
                return books.get(i);
            }
        }
        return null;
    }
}
