package blackjack;

public class Player {
    private String name;
    private int score = 0;
    private Card[] card = new Card[11];
    private boolean blackjack;
    private boolean lost;
    private int number_of_cards = 2;

    public String getName() {
        return name;
    }

    public int getScore() {
        calculate_score();
        return score;
    }

    public Player(String name, Card[] card, boolean blackjack, boolean lost) {
        this.name = name;
        set_cards(card);
        this.blackjack = blackjack;
        this.lost = lost;
        calculate_score();
    }

    void calculate_score() {
        score = 0;
        for (int i = 0; i < 11; i++) {
            if (card[i] != null) {
                score = score + card[i].getValue();
            } else {
                break;
            }
        }
        if (score > 21) {
            lost = true;
        } else if (score == 21) {
            blackjack = true;
        }
    }

    public Card[] getCard() {
        return card;
    }

    void set_cards(Card[] drawn_cards) {
        for (int i = 0; i < 2; i++) {
            card[i] = new Card(drawn_cards[i]);
        }
    }

    public boolean isLost() {
        return lost;
    }

    void set_card(Card card) {
        for (int i = 0; i < 11; i++) {
            if (this.card[i] == null) {
                this.card[i] = card;
                break;
            }
        }
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    void setCard(Card card) {
        if (number_of_cards != 11) {
            this.card[number_of_cards] = card;
            number_of_cards++;
        }
    }
}