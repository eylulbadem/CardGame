package cardgame;

/**
 * Card - a single playing card
 * 
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class Card {
	final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs" };
	final String[] FACES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	final int NOOFCARDSINSUIT = 13;

	// properties
	int cardNo;

	// constructors
	public Card(int faceValue, int suit) {
		cardNo = faceValue + suit * NOOFCARDSINSUIT;
	}

	public Card(int cardNumber) {
		cardNo = cardNumber;
	}

	public int getFaceValue() {
		return cardNo % NOOFCARDSINSUIT;
	}

	public int getSuit() {
		return cardNo / NOOFCARDSINSUIT;
	}

	public String toString() {
		return FACES[getFaceValue()] + " of " + SUITS[getSuit()];
	}

	/**
     * this method checks if the given cards are the same
     * @param c card to be compared
     * @return equal (true if two value of two cards are equal)
     */
	public boolean equals(Card c) {
		boolean equal;
		if (getFaceValue() == c.getFaceValue() && getSuit() == c.getSuit()) {
			equal = true;
		} else
			equal = false;
		return equal;
	}

	/**
     * this method compares value of two cards
     * @param c card to be compared
     * @return int values for each case
     */
	public int compareTo(Card c) {
		if(getFaceValue()==c.getFaceValue())
			return 0;
		else if (getFaceValue()>c.getFaceValue())
			return 1;
		else 
			return 2;
	}
}