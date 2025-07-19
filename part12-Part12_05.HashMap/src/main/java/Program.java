
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        HashMap<String, Integer> map = new HashMap<>();
        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
        map.add("one", 100); 

        System.out.println("one: " + map.get("one"));     
        System.out.println("two:" + map.get("two"));     
        System.out.println("three: " + map.get("three")); 
        System.out.println("four: " + map.get("four"));  
    }

}
