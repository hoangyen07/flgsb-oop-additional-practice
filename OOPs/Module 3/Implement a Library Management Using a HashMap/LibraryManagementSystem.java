import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.time.Year;

public class LibraryManagementSystem {
    // Book class to represent book information
    static class Book {
        // Step 1: Declare variables for title, author, genre, and publication year
        // Hint: Use appropriate data types (String for text, int for year)
        private String title;
        private String author;
        private String genre;
        int year;

        // Step 2: Create a constructor for the Book class
        // Hint: The constructor should take parameters for all book attributes
        public Book(String title, String author, String genre, int year) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.year = year;
        }
        // Step 3: Create getter methods for each attribute
        // Hint: Use the format: public dataType getAttribute()

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public int getYear() {
            return year;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setYear(int year) {
            this.year = year;
        }

        // Step 4: Create a method to display book details
        // Hint: Return a formatted string with all book information
        @Override
        public String toString() {
            return "Book " + title + " is written by " + author + " in " + genre + " in " + year;
        }
    }

    // Method to validate if the title and author have valid formats
    private static boolean isValidText(String text) {
        // Step 5: Implement validation to ensure text isn't empty
        // Hint: Check if the string is null, empty, or only whitespace
        return text != null && !text.trim().isEmpty(); // Replace this with your implementation
    }

    // Method to validate publication year
    private static boolean isValidYear(int year) {
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        return year >= 1000 && year <= Year.now().getValue(); // Replace this with your implementation
    }

    public static void main(String[] args) {
        // Step 7: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Step 8: Create a HashMap to store books (with ISBN as the key)
        HashMap<String, Book> library = new HashMap<>();
        boolean exit = false;
        // Step 9: Implement the main loop with menu options
        // Hint: Options should include adding a book, viewing all books,
        // searching for books, removing a book, viewing sorted books, and exiting
        while (!exit) {
            System.out.println("============= Welcome to our library ===========");
            System.out.println("Please select one of these option below: ");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book.");
            System.out.println("4. Remove a book");
            System.out.println("5. View sorted books");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Please input ISBN of book: ");
                    String ISBN = scanner.nextLine();
                    System.out.println("");
                    Book book = new Book("book1", "author", "drama", 2020);
                    library.put(ISBN, book);
                    break;
                case 2:
                    System.out.println("List books: ");
                    if (library.isEmpty()) {
                        System.out.println("The library is empty!");
                    } else {
                        System.out.println("\n===== Library Catalog =====");
                        for (Map.Entry<String, Book> entry : library.entrySet()) {
                            System.out.println("ISBN: " + entry.getKey() + ", " + entry.getValue().toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Search book.");
                    System.out.println("Please select type of search: " +
                            "\n 1. Search by title" +
                            "\n 2. Search by author" +
                            "\n 3. Search by year");
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter search key word: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    if (select == 1) {
                        for (Map.Entry<String, Book> entry : library.entrySet()) {
                            if (entry.getValue().getTitle().toLowerCase().equals(keyword)) {
                                System.out.println("Book found.");
                                System.out.println(entry.getValue().toString());
                            }
                        }
                        System.out.println("Not found");

                    }
                    break;
                case 4:
                    // Step 13: Implement the "Remove a book" option
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String id = scanner.nextLine();

                    if (library.containsKey(id)) {
                        Book removedBook = library.remove(id);
                        System.out.println("Book removed successfully:");
                        System.out.println("ISBN: " + id + ", " + removedBook);
                    } else {
                        System.out.println("No book found with ISBN: " + id);
                    }
                    break;
                case 5:
                    System.out.println("Sort books.");
                    // Sort by title using TreeMap with custom comparator
                    TreeMap<String, Book> sortedByTitle = new TreeMap<>(
                            Comparator.comparing(isbn -> library.get(isbn).getTitle())
                    );
                    sortedByTitle.putAll(library);

                    System.out.println("\n===== Books Sorted by Title =====");
                    for (Map.Entry<String, Book> entry : sortedByTitle.entrySet()) {
                        System.out.println("ISBN: " + entry.getKey() + ", " + entry.getValue());
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Good bye");
                    break;
            }
        }
    }
}