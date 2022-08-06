package cardgame;
import cardgame.*;

/**
 * CardGameTest
 * 
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class CardGameTest
{
    public static void main( String[] args)
    {
        System.out.println( "Start of CardGameTest\n");
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        CardGame   game;
        Player     p1, p2, p3, p4;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card(0);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p1 = new Player( "eylül");
        p2 = new Player( "ipek");
        p3 = new Player( "emir");
        p4 = new Player( "ekin");
        
        System.out.println(p1.getName().toUpperCase());
        
        // test CardGame class 
        game = new CardGame(p1, p2, p3, p4);
        game.dealCards();
        game.getWinners();
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest