
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("\nInput the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(name, age));
            System.out.println();
        }

        System.out.println(books.size() + " books in total.\n");

        Comparator<Book> comparator = Comparator
                        .comparing(Book::getAgeRecommendation)
                        .thenComparing(Book::getName);
        Collections.sort(books, comparator);

        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
