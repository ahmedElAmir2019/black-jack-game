package blackjack;

import java.util.Scanner;

public class BlackJack {
    private static Game game=new Game();
    private static GUI gui = new GUI();
    public  static void main(String[] args) {
        game.make_player();
        Player[] player=game.getPlayer();
        gui.runGUI(game.getCards(),player[0].getCard(),player[1].getCard(),player[2].getCard(),player[3].getCard());
        start_game();
        boolean game_is_ended=true;
        game_is_ended=  end_game();
        if (!game_is_ended)
        {
            who_is_winner();
        }
    }

    private static void start_game()
    {
        Scanner scanner=new Scanner(System.in);
        Player[] player =new Player[4];
        player=game.getPlayer();
        for (int i = 0 ; i<3; i++)
        {
            System.out.println(player[i].getName() + "'s turn \n");
            System.out.println(player[i].getName() + "'s Score "+ player[i].getScore());

            while (true)
            {
                System.out.println("Hit or Stand \n");
                String choise= scanner.next();
                if (choise.equals("Hit"))
                {
                    Card card=game.draw();
                    player[i].set_card(card);
                    System.out.println(player[i].getScore());
                    gui.updatePlayerHand(card,i);
                    if (player[i].isLost())
                    {
                        System.out.println("BUSTED");
                        break;
                    }
                    else if (player[i].isBlackjack())
                    {
                        break;
                    }
                }
                else if (choise.equals("Stand"))
                {
                    break;
                }
                else
                {
                    System.out.println("invalid input please try again \n");
                }
            }
            game.updating_maximum_score();
        }
    }
    private static boolean end_game()
    {
        boolean game_is_ended=false;
        Scanner scanner=new Scanner(System.in);
        Player[] player =new Player[4];
        player=game.getPlayer();
        System.out.println(player[3].getName() + "'s turn \n");
        System.out.println(player[3].getName() + "'s Score "+ player[3].getScore());
        while (true)
        {
            if (player[3].getScore()>game.getHigh_score())
            {
                System.out.println(" delar is WINNER");
                game_is_ended=true;
                break;
            }
            System.out.println("Hit or Stand \n");
            String choise= scanner.next();
            if (choise.equals("Hit"))
            {
                Card card=game.draw();
                player[3].set_card(card);
                gui.updateDealerHand(card,game.getCards());
                System.out.println(player[3].getScore());
                if (player[3].isLost())
                {
                    System.out.println("BUSTED");
                    break;
                }
                else if (player[3].isBlackjack())
                {
                    System.out.println("WIN");
                    game_is_ended=true;
                    break;
                }
                else if (player[3].getScore()> game.getHigh_score())
                {
                    System.out.println(" delar is WINNER");
                    game_is_ended=true;
                    break;
                }
            }
            else if (choise.equals("Stand"))
            {
                if (player[3].getScore()== game.getHigh_score())
                {
                    System.out.println("PUSH");
                    game_is_ended=true;
                }

                break;
            }
            else
            {
                System.out.println("invalid input please try again \n");
            }
        }
        return game_is_ended;
    }
    private static void who_is_winner()
    {
        Player[] player =new Player[4];
        player=game.getPlayer();
        int First_High_score=-1;
        int index=-1;
        boolean push=false;
        for (int i=0;i<4;i++)
        {
            if (player[i].getScore()==First_High_score)
            {
                System.out.println("PUSH");
                push=true;
                break;
            }
            if (player[i].getScore()<=21&&player[i].getScore()>First_High_score)
            {
                First_High_score=player[i].getScore();
                index=i;
            }
        }
        if (!push)
        {
            System.out.println("Winner is " + player[index].getName());
        }
    }
}
