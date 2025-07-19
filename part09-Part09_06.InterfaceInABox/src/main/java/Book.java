public class Book implements Packable {
    private String author;
    private String book;
    private double weight;

    public Book(String author, String book, double weight) {
        this.author = author;
        this.book = book;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return author + ": " + book;
    }
}
