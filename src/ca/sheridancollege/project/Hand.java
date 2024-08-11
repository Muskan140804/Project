package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public PlayingCard playCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public void addCards(List<PlayingCard> newCards) {
        cards.addAll(newCards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
