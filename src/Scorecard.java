import java.util.Arrays;

public class Scorecard {

	int[] card = new int[13];
	boolean[] possible = new boolean[13];
	
	//Constructor
	public Scorecard() {
		Arrays.fill(card, -1);
		Arrays.fill(possible, false);
	}
	
	//13 different if statements, checking each scoring category with the dice array to see which ones are eligible to be scored
	public void currentEligibleScores(Dice[] dice) {
		int aces, twos, threes, fours, fives, sixes, threeOfAKind, fourOfAKind, fullHouse, smallStraight, largeStraight, yahtzee, chance;
		int arrayLength = dice.length;
		
		//Aces
		if (dice[0].value == 1 || dice[1].value == 1 || dice[2].value == 1 || dice[3].value == 1 || dice[4].value == 1) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 1) {
					aces++;
				}
			}
		}
		
		//Twos
		if (dice[0].value == 2 || dice[1].value == 2 || dice[2].value == 2 || dice[3].value == 2 || dice[4].value == 2) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 2) {
					aces += 2;
				}
			}
		}
		
		//Threes
		if (dice[0].value == 3 || dice[1].value == 3 || dice[2].value == 3 || dice[3].value == 3 || dice[4].value == 3) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 3) {
					aces += 3;
				}
			}
		}
		
		//Fours
		if (dice[0].value == 4 || dice[1].value == 4 || dice[2].value == 4 || dice[3].value == 4 || dice[4].value == 4) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 4) {
					aces += 4;
				}
			}
		}
		
		//Fives
		if (dice[0].value == 5 || dice[1].value == 5 || dice[2].value == 5 || dice[3].value == 5 || dice[4].value == 5) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 5) {
					aces += 5;
				}
			}
		}
		
		//Sixes
		if (dice[0].value == 6 || dice[1].value == 6 || dice[2].value == 6 || dice[3].value == 6 || dice[4].value == 6) {
			aces = 0;
			for (int i = 0; i < arrayLength; i++) {
				if (dice[i].value == 6) {
					aces += 6;
				}
			}
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