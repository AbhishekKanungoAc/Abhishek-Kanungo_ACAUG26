package OopjMainThreeQue;

import java.util.*;
import java.io.*;


// Custom Exception
class BookNotAvailableException extends Exception {

    BookNotAvailableException(String message) {
        super(message);
    }
}


// Book class
class Book implements Serializable {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    void display() {

        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        if (available)
            System.out.println("Status: Available");
        else
            System.out.println("Status: Issued");

        System.out.println("-------------------");
    }
}


// Interface
interface LibraryOperations {

    void issueBook(int bookId) throws BookNotAvailableException;

    void returnBook(int bookId);

    void searchBook(String title);
}


// Library class
class Library implements LibraryOperations {

    private ArrayList<Book> books = new ArrayList<>();


    // Add book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }


    // Display books
    void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.display();
        }
    }


    // Issue book
    @Override
    public void issueBook(int bookId) throws BookNotAvailableException {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (!book.isAvailable()) {
                    throw new BookNotAvailableException(
                        "Book is already issued"
                    );
                }

                book.setAvailable(false);

                System.out.println("Book issued successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }


    // Return book
    @Override
    public void returnBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                book.setAvailable(true);

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }


    // Search book
    @Override
    public void searchBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                book.display();
                return;
            }
        }

        System.out.println("Book not found.");
    }


    // Save books into file
    void saveBooks() {

        try {

            ObjectOutputStream out =
                new ObjectOutputStream(
                    new FileOutputStream("books.dat")
                );

            out.writeObject(books);

            out.close();

            System.out.println("Books saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving books.");
        }
    }


    // Load books from file
    void loadBooks() {

        try {

            ObjectInputStream in =
                new ObjectInputStream(
                    new FileInputStream("books.dat")
                );

            books = (ArrayList<Book>) in.readObject();

            in.close();

            System.out.println("Books loaded successfully.");

        } catch (Exception e) {

            System.out.println("No previous data found.");
        }
    }
}


// Main class
public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.loadBooks();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);

                    library.addBook(book);

                    break;


                case 2:

                    library.displayBooks();

                    break;


                case 3:

                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();

                    try {

                        library.issueBook(issueId);

                    } catch (BookNotAvailableException e) {

                        System.out.println(
                            "BookNotAvailableException: "
                            + e.getMessage()
                        );
                    }

                    break;


                case 4:

                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;


                case 5:

                    sc.nextLine();

                    System.out.print("Enter book title: ");
                    String searchTitle = sc.nextLine();

                    library.searchBook(searchTitle);

                    break;


                case 6:

                    library.saveBooks();

                    System.out.println("Exiting...");

                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}