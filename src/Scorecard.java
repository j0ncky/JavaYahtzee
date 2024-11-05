import java.util.Arrays;

public class Scorecard {

	protected int[] card = new int[13];
	protected boolean[] possible = new boolean[13];
	protected int totalScore;
	
	protected boolean yahtzeeBonusAvailable;
	protected boolean upperSectionBonusObtained;
	
	protected String[] categories = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", 
			 						 "3 of a Kind", "4 of a Kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance" };
	
	//Constructor
	public Scorecard() {
		Arrays.fill(card, -1);
		Arrays.fill(possible, false);
		
		totalScore = 0;
		
		yahtzeeBonusAvailable = false;
		upperSectionBonusObtained = false;
	}
	
	//13 different, long if statements, checking each scoring category with the dice array to see which ones are eligible to be scored
	public void currentEligibleScores(Dice[] dice) {
		
		int n = 0;
		Arrays.fill(possible, false);
		
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
		
		//6 of a kind (6 OF A KIND ONLY)

		
		//Split (6 OF A KIND ONLY)

		
		//Giant Straight (6 OF A KIND ONLY)
		
		
	}
	
	protected int selectedScoreValue(Dice[] dice, int selection) {
		int score = 0;
		
		switch (selection) {
		case 1: //Aces
			for (Dice die : dice) {
				
				if (die.value == 1) { score += die.value; }
			}
			break;
			
		case 2:
			for (Dice die : dice) {
				if (die.value == 2) { score += die.value; }
			}
			break;
			
		case 3:
			for (Dice die : dice) {
				if (die.value == 3) { score += die.value; }
			}
			break;
		
		case 4:
			for (Dice die : dice) {
				if (die.value == 4) { score += die.value; }
			}
			break;
			
		case 5:
			for (Dice die : dice) {
				if (die.value == 5) { score += die.value; }
			}
			break;
			
		case 6:
			for (Dice die : dice) {
				if (die.value == 6) { score += die.value; }
			}
			break;
			
		case 7:
			for (Dice die : dice) {
				score += die.value;
			}
			break;
			
		case 8:
			for (Dice die : dice) {
				score += die.value;
			}
			break;
			
		case 9:
			score += 25;
			break;
			
		case 10:
			score += 30;
			break;
			
		case 11:
			score += 40;
			break;
			
		case 12:
			if (!yahtzeeBonusAvailable) {
				yahtzeeBonusAvailable = true;
				score += 50;
			}
			else if (yahtzeeBonusAvailable) {
				score += 100;
			}
			break;
			
		case 13:
			for (Dice die : dice) {
				score += die.value;
			}
			break;
			
		}
		
		return score;
	}
	
	protected void saveScoreSelection(Dice[] dice, int selection, boolean zero) {
		//Only does calculation of selected score category
		//If statements in case the score to be recorded is zero
		int score = -1;
		
		if (zero) { score = 0; }
		
		else {
			
			switch (selection) {
			case 1: //Aces
				for (Dice die : dice) {
					if (die.value == 1) { score += 1; }
				}
				break;
				
			case 2:
				for (Dice die : dice) {
					if (die.value == 2) { score += 2; }
				}
				break;
				
			case 3:
				for (Dice die : dice) {
					if (die.value == 3) { score += 3; }
				}
				break;
			
			case 4:
				for (Dice die : dice) {
					if (die.value == 4) { score += 4; }
				}
				break;
				
			case 5:
				for (Dice die : dice) {
					if (die.value == 5) { score += 5; }
				}
				break;
				
			case 6:
				for (Dice die : dice) {
					if (die.value == 6) { score += 6; }
				}
				break;
				
			case 7:
				for (Dice die : dice) {
					score += die.value;
				}
				break;
				
			case 8:
				for (Dice die : dice) {
					score += die.value;
				}
				break;
				
			case 9:
				score += 25;
				break;
				
			case 10:
				score += 30;
				break;
				
			case 11:
				score += 40;
				break;
				
			case 12:
				if (!yahtzeeBonusAvailable) {
					yahtzeeBonusAvailable = true;
					score += 50;
				}
				else if (yahtzeeBonusAvailable) {
					score += 100;
				}
				break;
				
			case 13:
				for (Dice die : dice) {
					score += die.value;
				}
				break;
				
			}
			
		}
		
		
		card[selection - 1] = score;
		
		if ((card[0] + card[1] + card[2] + card[3] + card[4] + card[5]) >= 63) {
			upperSectionBonusObtained = true;
		}
		
		System.out.println("Score recorded\n");
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
		totalScore = 0;
		for (int i = 0; i < card.length; i++) {
			
			if (card[i] == -1) 
				{ totalScore += 0; }
			else 
				{ totalScore += card[i]; }
			
		}
		
		return totalScore;
	}
	
	public void applyUpperBonus(boolean obtained) {
		if (obtained) {
			totalScore += 35;
		}
	}
}