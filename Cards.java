package cardgame;

import java.util.Random;

/**
 *  Cards - Maintains a collection of zero or more playing cards.
 *          Provides facilities to create a full pack of 52 cards
 *          and to shuffle the cards.
 *  
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class Cards {
	final int NOOFCARDSINFULLPACK = 52;

	// properties
	Card[] cards;
	int valid; // number of cards currently in collection

	// constructors
	public Cards(boolean fullPack) {
		cards = new Card[NOOFCARDSINFULLPACK];
		valid = 0;

		if (fullPack)
			createFullPackOfCards();
	}

	// methods
	public Card getTopCard() {
		Card tmp;

		if (valid <= 0)
			return null;
		else {
			valid--;
			tmp = cards[valid];
			cards[valid] = null;
			return tmp;
		}
	}

	public boolean addTopCard(Card c) {
		if (valid < cards.length) {
			cards[valid] = c;
			valid++;
			return true;
		}
		return false;
	}

	private void createFullPackOfCards() {
		for(int i = 0; i<52;i++){
			addTopCard(new Card(i));
		}
	}

	/**
     * shuffles the pack using random generator
     * 
     */
	public void shuffle() {
		Random shuffle = new Random();  			
		 
		for (int i=0; i<cards.length; i++) {
		    int randomPosition = shuffle.nextInt(cards.length);
		    Card temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
		}
	}
	
} // end class Cards