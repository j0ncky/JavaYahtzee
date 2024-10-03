import java.util.Arrays;

public class Scorecard {

	protected int[] card = new int[13];
	protected boolean[] possible = new boolean[13];
	protected boolean yahtzeeBonus = false;
	
	//Constructor
	public Scorecard() {
		Arrays.fill(card, -1);
		Arrays.fill(possible, false);
	}
	
	//13 different, long if statements, checking each scoring category with the dice array to see which ones are eligible to be scored
	public void currentEligibleScores(Dice[] dice) {
		
		int diceArrayLength = dice.length;
		int n = 0;
		
		//Aces
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 1 || dice[1].value == 1 || dice[2].value == 1 || dice[3].value == 1 || dice[4].value == 1) {
			possible[n] = true;
		}
		n++;
		
		//Twos
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 2 || dice[1].value == 2 || dice[2].value == 2 || dice[3].value == 2 || dice[4].value == 2) {
			possible[n] = true;
		}
		n++;
		
		//Threes
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 3 || dice[1].value == 3 || dice[2].value == 3 || dice[3].value == 3 || dice[4].value == 3) {
			possible[n] = true;
		}
		n++;
		
		//Fours
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 4 || dice[1].value == 4 || dice[2].value == 4 || dice[3].value == 4 || dice[4].value == 4) {
			possible[n] = true;
		}
		n++;
		
		//Fives
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 5 || dice[1].value == 5 || dice[2].value == 5 || dice[3].value == 5 || dice[4].value == 5) {
			possible[n] = true;
		}
		n++;
		
		//Sixes
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (dice[0].value == 6 || dice[1].value == 6 || dice[2].value == 6 || dice[3].value == 6 || dice[4].value == 6) {
			possible[n] = true;
		}
		n++;
		
		//3 of a kind
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (((dice[0].value == dice[1].value) && (dice[1].value == dice[2].value)) 
		      || ((dice[1].value == dice[2].value) && (dice[2].value == dice[3].value))
		      || ((dice[2].value == dice[3].value) && (dice[3].value == dice[4].value))) {
			possible[n] = true;
		}
		n++;
		
		//4 of a kind
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (((dice[0].value == dice[1].value) && (dice[1].value == dice[2].value) && (dice[2].value == dice[3].value))
		       || (dice[1].value == dice[2].value) && (dice[2].value == dice[3].value) && (dice[3].value == dice[4].value)) {
			possible[n] = true;
		}
		n++;
		
		//Full house
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (((dice[0].value == dice[1].value) && (dice[1].value == dice[2].value)) && (dice[3].value == dice[4].value)
		       || (dice[0].value == dice[1].value) && ((dice[2].value == dice[3].value) && (dice[3].value == dice[4].value))) {
			possible[n] = true;
		}
		n++;
			
		//Small straight
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if (((dice[0].value + 1 == dice[1].value) && (dice[1].value + 1 == dice[2].value) && (dice[2].value + 1 == dice[3].value))
		      || ((dice[1].value + 1 == dice[2].value) && (dice[2].value + 1 == dice[3].value) && (dice[3].value + 1 == dice[4].value))) {
			possible[n] = true;
		}
		n++;
		
		//Large straight
		if (card[n] != -1) {
			possible[n] = false;
		}
		else if ((dice[0].value + 1 == dice[1].value) && (dice[1].value + 1 == dice[2].value) && (dice[2].value + 1 == dice[3].value) && (dice[3].value + 1 == dice[4].value)) {
			possible[n] = true;
		}
		n++;
		
		//Yahtzee
		if (card[n] == 0) {
			possible[n] = false;
		}
		else if ((dice[0].value == dice[1].value) && (dice[1].value == dice[2].value) && (dice[2].value == dice[3].value) && (dice[3].value == dice[4].value)) { 
			possible[n] = true;
		}
		n++;
		
		//Chance
		if (card[n] != -1) {
			possible[n] = false;
		}
		else {
			possible[n] = true;
		}
		   	
		for (int i = 0; i < possible.length; i++) {
			
			if (possible[i] == true) {
				System.out.println(i);
			} else if (possible[i] == false && card[i] == -1) {
				System.out.println(i + "\tx");
			}
		}
		
	}
	
	public void saveScoreSelection(int selection, boolean zero) {
		//switch statements with selection integer
		//each case will have an if statement to check if the user wanted to input a zero, and if not it will save the appropriate score.
		
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
		
		//Prints upper section
		System.out.println("\nUPPER SECTION");
		System.out.println("| Aces: [" + values[0] + "] | Twos: [" + values[1] + "] | Threes: [" + values[2] + 
						   "] | Fours: [" + values[3] + "] | Fives: [" + values[4] + "] | Sixes: [" + values[5] + "] |");
		
		//Prints lower section
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