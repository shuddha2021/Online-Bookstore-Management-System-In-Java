import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

class Bookstore {
    private List<Book> books;

    public Bookstore() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the bookstore.");
        } else {
            System.out.println("Books in the Bookstore:");
            System.out.println("-------------------------");
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: $" + book.getPrice());
                System.out.println("-------------------------");
            }
        }
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public void purchaseBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Purchasing book: " + book.getTitle());
            System.out.println("Price: $" + book.getPrice());
            books.remove(book);
            System.out.println("Book purchased successfully!");
        } else {
            System.out.println("Book not found in the bookstore.");
        }
    }
}

public class OnlineBookstoreManagementSystem {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        // Adding books to the bookstore
        bookstore.addBook(new Book("Java Programming", "John Smith", 29.99));
        bookstore.addBook(new Book("Python for Beginners", "Alice Johnson", 19.99));
        bookstore.addBook(new Book("Data Structures and Algorithms", "Michael Brown", 39.99));

        // Displaying all books in the bookstore
        bookstore.displayBooks();

        // Searching books by title
        System.out.println("Searching books by title: 'java'");
        List<Book> searchResults = bookstore.searchByTitle("java");
        for (Book book : searchResults) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: $" + book.getPrice());
            System.out.println("-------------------------");
        }

        // Purchasing a book
        Book bookToPurchase = new Book("Java Programming", "John Smith", 29.99);
        bookstore.purchaseBook(bookToPurchase);

        // Displaying updated list of books
        bookstore.displayBooks();
    }
}
