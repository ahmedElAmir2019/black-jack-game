package blackjack;

public class Card {
    final private int suit ;
    final private int rank ;
    final private int value ;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public Card(Card copy) {
        this.suit = copy.suit;
        this.rank = copy.rank;
        this.value = copy.value;
    }
}
