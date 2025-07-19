
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here
        List<String> myList = new List<>();

        System.out.println(myList.contains("hello")); 

        myList.add("hello");
        myList.add("world");

        System.out.println(myList.contains("hello")); 
        System.out.println(myList.size());          

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.value(i));     
        }

        myList.remove("hello");
        System.out.println(myList.contains("hello"));
    }

}
