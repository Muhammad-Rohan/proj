//import DSA_PROJECT.Library;

import java.util.Scanner;

import javax.tools.Tool;

public class Start {

    Library library = new Library();
    Scanner sc = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println("1 to add Books");
            System.out.println("2 to remove Books");
            System.out.println("3 to display Books");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1: {
                    int n;
                    System.out.print("How many Books you want to enter: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Details of Book " + (i + 1));
                        System.out.print("Enter Book ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Book Name: ");
                        String bookName = sc.nextLine();

                        System.out.print("Enter Book category: ");
                        String category = sc.next();

                        library.addBook(id, bookName, category);
                    }
                    library.displayBook();

                    break;
                } // case 1 ends

                case 2: {
                    int n;
                    System.out.print("How many Books you want to REMOVE: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Book ID to remove ");
                        int id = sc.nextInt();
                        library.removeBook(id);
                    }
                    library.displayBook();
                    break;
                }

                case 3: {
                    library.displayBookFromDB();
                    break;
                }

                default: {
                    System.out.println("Invalid KEY pressed ");
                    break;
                }

            }

        }

    }

    public void main(String[] args) {

        while (true) {
            run();
        }

    }
}
