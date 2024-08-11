/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */


package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Game {

    private final String name;
    private List<Player> players;
    private Player winner;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void play() {
        while (!isGameOver()) {
            playRound();
        }
        declareWinner();
    }

    private void playRound() {
        List<PlayingCard> roundCards = playCards();
        determineRoundWinner(roundCards);
    }

    private List<PlayingCard> playCards() {
        List<PlayingCard> roundCards = new ArrayList<>();
        for (Player player : getPlayers()) {
            PlayingCard playedCard = player.getHand().playCard();
            if (playedCard != null) {
                roundCards.add(playedCard);
            }
        }
        return roundCards;
    }

    private void determineRoundWinner(List<PlayingCard> roundCards) {
        PlayingCard highestCard = findHighestCard(roundCards);
        winner = findPlayerWithCard(roundCards, highestCard);
        winner.getHand().addCards(roundCards);
    }

    private PlayingCard findHighestCard(List<PlayingCard> cards) {
        return cards.stream()
                .max(Comparator.comparingInt(card -> card.getRank().ordinal()))
                .orElse(null);
    }

    private Player findPlayerWithCard(List<PlayingCard> cards, PlayingCard targetCard) {
        return getPlayers().stream()
                .filter(player -> player.getHand().getCards().contains(targetCard))
                .findFirst()
                .orElse(null);
    }

    private boolean isGameOver() {
        return getPlayers().stream().anyMatch(player -> player.getHand().isEmpty());
    }

    public void declareWinner() {
        if (winner != null) {
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}
