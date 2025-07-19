package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
SaveableDictionary dictionary = new SaveableDictionary("words.txt");
dictionary.load();

dictionary.add("apina", "monkey");
dictionary.add("banaani", "banana");
dictionary.add("ohjelmointi", "programming");

dictionary.save();


    }
}
