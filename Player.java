package cardgame;

/**
 *  Player - Simple card game player with name and hand of cards 
 * 
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class Player {
	// properties
	String name;
	Cards hand;

	// constructors
	public Player(String name) {
		this.name=name;
		hand = new Cards(false);
	}

	// methods
	public String getName() {
		return name;
	}

	public void add(Card c) {
		hand.addTopCard(c);
	}

	public Card playCard() {
		return hand.getTopCard();
	}
	
	public String toString(){
		return getName();
	}

} // end class Player