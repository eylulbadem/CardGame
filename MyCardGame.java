package cardgame;
import java.util.Scanner;
import cardgame.*;

/**
 * MyCardGame - provides a menu allowing any of the players to play their card,
 *              an option to see the score card, and one to quit the game at any time.
 *              When the game is over it dislays the winners.
 * 
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class MyCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of MyCardGame\n");
        
        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        
        // VARIABLES
        Player     p1, p2, p3, p4;
        CardGame   game;
        int        selection;
        
        // PROGRAM CODE

        // create players...
        p1 = new Player( "eylül");
        p2 = new Player( "ipek");
        p3 = new Player( "emir");
        p4 = new Player( "ekin");
        
        // create game with the 4 players...
        game = new CardGame( p1, p2, p3, p4);
        
        game.dealCards();
        
        // display menu, get and process selection, until exit
        do
        {
            // display menu
            System.out.println();
            System.out.println( "MyCardGame   Round: " + game.getRoundNo() 
                                 + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
            System.out.println( MENU_SCORES + " - for Scores" );
            
            // ask for and get selection
            System.out.println();
            System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();
            
            // process selection
            if ( selection == MENU_PLAY_P1 )
                play( p1, game);
            
            else if ( selection == MENU_PLAY_P2 ) 
                play( p2, game);
            
            else if ( selection == MENU_PLAY_P3 ) 
                play( p3, game);

            else if ( selection == MENU_PLAY_P4 )
            {
                play( p4, game);
                System.out.println( game.showScoreCard() );
            }
            
            else if ( selection == MENU_SCORES )
                System.out.println( game.showScoreCard() );
            
            
        } while ( selection != MENU_EXIT || !game.isGameOver() );

        // display winners...
        System.out.println();
        System.out.println( game.showScoreCard() );
        System.out.println();
        System.out.println("Winner");
        for(int i=0; i<game.getWinners().length;i++){
        	System.out.println( game.getWinners()[i] );	
        }
        
        
        System.out.println( "\nEnd of MyCardGame\n" );   
    }

    static boolean play( Player p, CardGame game)
    {
        Card       c;
        boolean    accepted;
        
        c = p.playCard();
        
        accepted = game.playTurn(p, c);
        if(accepted == false){
            System.out.println( "It's not your turn! \n" );
            p.hand.addTopCard(c);
        }
        else
        System.out.println(c.toString());
        
        return accepted;
    }
    
    
    
} // end class MyCardGame