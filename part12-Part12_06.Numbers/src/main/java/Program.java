
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many random numbers should be printed?");
        int quantity = Integer.valueOf(scanner.nextLine());
        printRandomNumbers(quantity);
    }

    public static void printRandomNumbers(int quantity) {
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            System.out.println(random.nextInt(11));
            
        }
    }
}
