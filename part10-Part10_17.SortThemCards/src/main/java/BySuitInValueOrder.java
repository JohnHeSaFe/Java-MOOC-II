import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card>{
    @Override
    public int compare(Card o1, Card o2) {
        Comparator<Card> comparator = Comparator.comparing(Card::getSuit)
                                                .thenComparing(Card::getValue);
        return comparator.compare(o1, o2);
    }
}
