
public class Main {

    public static void main(String[] args) {
        // test your classes here
        Box box = new Box(50);
        Box miniBox = new Box(30);
        box.add(miniBox);
        box.add(new Book("Hello", "Hello", 10));
        System.out.println(box);
    }

}
