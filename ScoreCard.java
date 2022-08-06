package cardgame;

import java.util.ArrayList;

/**
 *  A Table Which Keeps The Scores
 * 
 * @author İpek Öztaş, Eylül Badem
 * @version 22/02/2021
 */
public class ScoreCard {
	// properties
	int[] scores;

	// constructors
	public ScoreCard(int noOfPlayers) {
		scores = new int[noOfPlayers];

		// init all scores to zero
		for (int i = 0; i < scores.length; i++)
			scores[i] = 0;
	}

	// methods
	public int getScore(int playerNo) {
		return scores[playerNo];
	}

	public void update(int playerNo, int amount) {
		scores[playerNo] += amount;
	}

	public String toString() {
		String s;
		s = "\n" + "_____________\n" + "\nPlayer\tScore\n" + "_____________\n";

		for (int playerNo = 0; playerNo < scores.length; playerNo++) {
			s = s + (playerNo+1) + "\t" + scores[playerNo] + "\n";
		}

		s += "_____________\n";
		return s;
	}

	/**
     * finds winning cards of the current round
     * 
     * @return integer array of winning cards' values
     */
	public int[] getWinners() {
		int maxScore = 0;
		int[] winners;
		ArrayList<Integer> winningScores = new ArrayList<Integer>();
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > maxScore) {
				maxScore = scores[i];
			}

		}

		for (int j = 0; j < scores.length; j++) {
			if (maxScore == scores[j]) {
				winningScores.add(j);
			}
		}

		winners = new int[winningScores.size()];
		for (int i = 0; i < winners.length; i++) {
			winners[i] = winningScores.get(i);
		}

		return winners;
	}

} // end class ScoreCard