import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Library {

//    public static class AddBook {
//        private int bookId;
//        private String bookName;
//        private String category;
//
//        public AddBook(int bookId, String bookName, String category) {
//            this.bookId = bookId;
//            this.bookName = bookName;
//            this.category = category;
//        }
//    }


    Book book = new Book();

    public void addBook(int bookId, String bookName, String category) {
        book.addBookInQueue(bookId, bookName, category);

        try {   // OPEN
            FileWriter writer = new FileWriter("src/BooksDB",true);
            writer.write(bookId+" - "+"Book-Name '"+bookName+"' "+"Category: "+category+"\n");
            writer.close();

        } catch (Exception e) {
            System.out.println("Error 500: "+e.getMessage());
        }

    }

    public void removeBook(int id) {

        System.out.println("Removed book: "+book.removeBookFromQueue(id));  // id
        try {
        // Original file ko read karein
        File inputFile = new File("src/BooksDB");
        File tempFile = new File("src/BooksDB_temp");
        
        FileReader fr = new FileReader(inputFile);
        BufferedReader reader = new BufferedReader(fr);
        FileWriter writer = new FileWriter(tempFile);
        
        String line;
        // Har line ko read karein
        while ((line = reader.readLine()) != null) {
            // Check karein k current line mein wo book ID hai ya nahi
            String[] parts = line.split(" - ");
            int currentId = Integer.parseInt(parts[0]);
            
            // Agar current ID match nahi karti to line ko new file mein write kardein
            if (currentId != id) {
                writer.write(line + "\n");
            }
        }
        reader.close();
        writer.close();
        
        // Original file ko delete karein
        inputFile.delete();
        // Temporary file ka naam change karke original filename rakh dein
        tempFile.renameTo(inputFile);

    } catch (Exception e) {
        System.out.println("Error " + e.getMessage());
    }
    }



    public void displayBook() {
        book.display();
    }

    public void displayBookFromDB() {
        book.displayFromDB();
    }



}

