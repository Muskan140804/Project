package ca.sheridancollege.project;

import java.util.Iterator;

public class WarGame extends Game {

    private final GroupOfCards deck;

    public WarGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        initializeDeck();
        deck.shuffle();
        distributeCards();
    }

    private void initializeDeck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.getCards().add(new PlayingCard(rank, suit));
            }
        }
    }

    private void distributeCards() {
        Iterator<Player> playerIterator = getPlayers().iterator();
        for (PlayingCard card : deck.getCards()) {
            if (!playerIterator.hasNext()) {
                playerIterator = getPlayers().iterator();
            }
            Player player = playerIterator.next();
            player.getHand().addCard(card);
        }
    }

    @Override
    public void play() {
        super.play();
    }
}
