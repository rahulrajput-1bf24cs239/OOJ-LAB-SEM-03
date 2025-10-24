import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int num_pages;

    public Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public String toString() {
        return "\nBook Name: " + name +
               "\nAuthor: " + author +
               "\nPrice: " + price +
               "\nNumber of Pages: " + num_pages + "\n";
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(sc.nextLine());  // ✅ Read as full line then parse

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine()); // ✅ safer input

            System.out.print("Number of pages: ");
            int pages = Integer.parseInt(sc.nextLine()); // ✅ safer input

            books[i] = new Book(name, author, price, pages);
        }

        System.out.println("\n--- Book Details ---");
        for (Book b : books) {
            System.out.println(b);
        }

        sc.close();
    }
}




