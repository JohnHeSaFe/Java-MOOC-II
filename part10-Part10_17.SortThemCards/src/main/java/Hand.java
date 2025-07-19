import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    
    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.stream().forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand o) {
        int thisValues = cards.stream().mapToInt(card -> card.getValue())
                                       .sum();
        int otherValues = o.getCards().stream().mapToInt(card -> card.getValue())
                                       .sum();
        
        return thisValues - otherValues;
    }

    public List<Card> getCards() {
        return cards;
    }
}
