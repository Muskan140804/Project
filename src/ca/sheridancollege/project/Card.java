/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card
{
    public string Suit { get; set; }
    public string Rank { get; set; }

    public Card(string suit, string rank)
    {
        Suit = suit;
        Rank = rank;
    }

    public override string ToString()
    {
        return $"{Rank} of {Suit}";
    }
}

public class Deck
{
    private List<Card> cards;

    public Deck()
    {
        cards = new List<Card>();
        string[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        string[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        foreach (var suit in suits)
        {
            foreach (var rank in ranks)
            {
                cards.Add(new Card(suit, rank));
            }
        }

        Shuffle();
    }

    public void Shuffle()
    {
        Random rand = new Random();
        cards = cards.OrderBy(card => rand.Next()).ToList();
    }

    public Card DrawCard()
    {
        if (cards.Count > 0)
        {
            var card = cards[0];
            cards.RemoveAt(0);
            return card;
        }
        return null;
    }

    public int CardsRemaining()
    {
        return cards.Count;
    }
}

public class Player
{
    public string Name { get; set; }
    public List<Card> Hand { get; private set; }

    public Player(string name)
    {
        Name = name;
        Hand = new List<Card>();
    }

    public void DrawCard(Deck deck)
    {
        var card = deck.DrawCard();
        if (card != null)
        {
            Hand.Add(card);
        }
    }

    public override string ToString()
    {
        return $"{Name} has {Hand.Count} cards.";
    }
}

}
