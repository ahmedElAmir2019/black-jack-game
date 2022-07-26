package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] player=new Player[4];
    private Card[] cards = new Card[52];
    private int high_score=-1;

    public int getHigh_score() {
        return high_score;
    }

    public Player[] getPlayer() {
        return player;
    }

    private Scanner scanner =new Scanner(System.in);
    private Random random=new Random();
    void Genrte()
    {
        int index_of_card=0;
        for (int i=0 ; i<4;i++)
        {
            for (int j=0 ; j<13;j++)
            {
                int value=(j+1);
                if (value >10)
                {
                    value=10;
                }
                cards[index_of_card]=new Card(i,j,value);
                index_of_card++;
            }
        }
    }

    public Card[] getCards() {
        return cards;
    }

    Card draw()
    {
        int random_card_index;
        Card drawn_card ;
        while (true) {
            random_card_index=random.nextInt(52);
            if (cards[random_card_index] != null) {
                drawn_card = new Card(cards[random_card_index]);
                cards[random_card_index]=null;
                break;
            }
        }
        return drawn_card;
    }
    void make_player()
    {
        Genrte();
        for (int i=0;i<4;i++) {
            System.out.println("Please enter Player Name \n");
            String name = scanner.next();
            Card[] player_cards={draw(),draw()};
            player[i]=new Player(name,player_cards,false,false);
        }
    }
    void updating_maximum_score()
    {
        for (int i=0;i<3;i++) {
            if (player[i].getScore()>=high_score)
            {
                high_score=player[i].getScore();
            }
        }
    }
}
