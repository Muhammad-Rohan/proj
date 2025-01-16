// book queue

import java.io.File;
import java.util.Scanner;

public class Book {

    private BookData front;
    private BookData rear;
    private int size;

    public Book() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }


    public class BookData{  // node
        private String bookName;
        private int bookId;
        private String category;
        private BookData next;

        public BookData(int bookId, String bookName, String category) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.category = category;
        }

    }


    public void display() {
        BookData temp = front;

        while (temp != null) {
            System.out.print("ID: "+temp.bookId+" Book Name "+ temp.bookName+" category: "+ temp.category);
            temp = temp.next;
            System.out.println("\nBOOK HAS BEEN ADDED");
            System.out.println();
        }
        System.out.println();
    }



    public void displayFromDB() {
        try {
            File file = new File("src/BooksDB");
            Scanner reader = new Scanner(file);

            System.out.println("\nBooks from Database: ");
            System.out.println("------------------------------------------------------------------------------------");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
            System.out.println("------------------------------------------------------------------------------------");


        } catch (Exception e) {
            System.out.println("Error to reading the file: " + e.getMessage());
        }
        
    }





    public void addBookInQueue(int id, String bookName, String category) {
        BookData newBook = new BookData(id, bookName, category);

        if(rear == null) {
            front = newBook;
            rear = newBook;
        } else {
            rear.next = newBook;
            rear = newBook;
        }

        this.size++;

    }

    public String removeBookFromQueue() {
        String data = null;
        if (this.size == 0) {
            System.out.println("No Book to Remove ! ");
        } else {
            data = front.bookId+" "+front.bookName+" "+front.category;
            front = front.next;
        }
        this.size--;
        return data;
    }

    public String removeBookFromQueue(int id) {
        if (front == null) {
            return "No Book is present";
        }
        
        // Agr first node hi target hai
        if (front.bookId == id) {
            String data = front.bookId + " " + front.bookName + " " + front.category;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return data;
        }
        
        // Search the book with  ID
        BookData temp = front;
        BookData prev = null;
        
        while (temp != null && temp.bookId != id) {
            prev = temp;
            temp = temp.next;
        }
        
        // Agar book nahi mili
        if (temp == null) {
            return "Book ID " + id + " not Found";
        }
        
        // Book mil gai so remove it
        String data = temp.bookId + " " + temp.bookName + " " + temp.category;
        prev.next = temp.next;
        
        // Agar last node thi
        if (temp == rear) {
            rear = prev;
        }
        
        size--;
        return data;
    }

























}
