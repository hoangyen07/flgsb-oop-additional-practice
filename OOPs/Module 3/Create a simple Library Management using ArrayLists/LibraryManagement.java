import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// LibraryManagement class to manage the book collection
public class LibraryManagement {
    public static void main(String[] args) {
        // Step 1: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Step 2: Create an ArrayList to store Book objects
        // Hint: Use ArrayList<Book>
        List<Book> listBooks = new ArrayList<Book>();
        boolean exit = false;

        // Step 3: Implement a menu-driven program with the following options:
        // 1. Add a book
        // 2. View all books
        // 3. Search for a book by title
        // 4. Check out a book
        // 5. Return a book
        // 6. Sort books (by title, author, or publication year)
        // 7. View available books only
        // 8. Exit

        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break
        while (!exit) {
            System.out.println("=========== Welcome to book management ===============");
            System.out.println(" 1. Add a book" +
                    "\n 2. View all books" +
                    "\n 3. Search for a book by title" +
                    "\n 4. Check out a book" +
                    "\n 5. Return a book" +
                    "\n 6. Sort books (by title, author, or publication year)" +
                    "\n 7. View available books only" +
                    "\n 8. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n----- Add a New Book -----");

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    int year = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.print("Enter publication year: ");
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            validYear = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid year. Please enter a number.");
                        }
                    }

                    // add book to list
                    listBooks.add(new Book(title, author, year));

                    break;
                case 2:
                    System.out.println("Book Library: ");
                    for (Book book : listBooks) {
                        System.out.println(book.toString());
                    }
                    break;
                case 3:
                    System.out.println("Search book by title: ");
                    // check list book is not empty
                    if (listBooks.size() <= 0) {
                        System.out.println("Library is empty. Please add book first before search.");
                        break;
                    } else {
                        System.out.println("Enter keyword: ");
                        String key = scanner.nextLine();
                        for (Book book : listBooks) {
                            if (book.getBookTitle().equals(key)) {
                                System.out.println("Your book is found: " + book.toString());
                                break;
                            }
                        }
                        System.out.println("Cannot found your book.");
                    }
                    break;

                case 6:
                    System.out.println("Select the option that you want to sort book:");
                    System.out.println("Sort books (by title, author, or publication year)");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    switch (sortOption) {
                        case 1: // sort by title
                            Collections.sort(listBooks, new Comparator<Book>() {
                                @Override
                                public int compare(Book book1, Book book2) {
                                    return book1.getBookTitle().compareToIgnoreCase(book2.getBookTitle());
                                }
                            });
                            for (Book b : listBooks) {
                                System.out.println(b.toString());
                            }
                            break;
                    }
                case 8:
                    exit = true;
                    System.out.println("Bye.");
                    break;
            }
        }
        // Step 5: Implement case handling for each menu option
        // Hint: Use switch-case or if-else if statements

        // Step 6: Implement the addBook functionality
        // Hint: Prompt the user for title, author, and publication year

        // Step 7: Implement the viewAllBooks functionality
        // Hint: Use a loop or forEach to display all books

        // Step 8: Implement the search functionality
        // Hint: Take user input for search term and check each book

        // Step 9: Implement the checkOut functionality
        // Hint: Find the book by index and use the checkOut() method

        // Step 10: Implement the returnBook functionality
        // Hint: Find the book by index and use the returnBook() method

        // Step 11: Implement the sortBooks functionality
        // Hint: Use Collections.sort() with a Comparator

        // Step 12: Implement the viewAvailableBooks functionality
        // Hint: Use ArrayList's stream() or loop through to filter
    }

    // Step 13: Create additional helper methods as needed
    // Examples: findBookByTitle(), findBookByIndex(), etc.
}
