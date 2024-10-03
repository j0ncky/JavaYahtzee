import java.util.Arrays;

public class Scorecard {

	int[] card = new int[13];
	boolean[] possible = new boolean[13];
	
	//Constructor
	public Scorecard() {
		Arrays.fill(card, -1);
		Arrays.fill(possible, false);
	}
	
	public void currentEligibleScores(Dice[] dice) {
		for (int i = 0; i < possible.length; i++) {
			System.out.println(possible[i]);
		}
	}
	
	public void displayCurrentScores() {
		String[] values = new String[13];
		
		//This is to manage my method of using -1 for scores that haven't been recorded yet, since I don't want to display someone has a -1 for a score
		for (int i = 0; i < values.length; i++) {
			if (card[i] == -1) {
				values[i] = " ";
			}
			else {
				values[i] = String.valueOf(card[i]);
			}
		}
		
		System.out.println("\nUPPER SECTION");
		System.out.println("| Aces: [" + values[0] + "] | Twos: [" + values[1] + "] | Threes: [" + values[2] + 
						   "] | Fours: [" + values[3] + "] | Fives: [" + values[4] + "] | Sixes: [" + values[5] + "] |");
		
		System.out.println("\nLOWER SECTION");
		System.out.println("| 3 of a kind: [" + values[6] + "] | 4 of a kind: [" + values[7] + "] | Full House: [" + values[8] + "] | Small Straight: [" + values[9] +
						   "] | Large Straight: [" + values[10] + "] | YAHTZEE: [" + values[11] + "] | Chance: [" + values[12] + "] |\n");
		
	}
	
	public int totalScore() {
		int total = 0;
		for (int i = 0; i < card.length; i++) {
			total += card[i];
		}
		return total;
	}
}