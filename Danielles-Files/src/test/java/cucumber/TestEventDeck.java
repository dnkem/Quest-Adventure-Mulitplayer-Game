package cucumber;

import org.example.Card;
import org.example.Deck;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestEventDeck extends Deck {
    private Queue<Card> testCards;

    public TestEventDeck(List<Card> cards) {
        super(cards);
        testCards = new LinkedList<>(cards);
    }
}

