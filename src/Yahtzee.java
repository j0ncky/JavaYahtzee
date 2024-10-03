import java.util.Scanner;
import java.util.Random;

public class Yahtzee {
    
	//Main
	public static void main(String[] args) {
        
		//Initialization of variables needed from beginning of game
		boolean[] players = new boolean[6];
        int playerCount = 0;
        
        Scorecard[] scorecards;
        int categorySelection = -1;
        boolean zeroOverScore = false;
        
        Dice[] diceArray = new Dice[5];
        boolean[] savedDice = new boolean[5];
        
        Scanner scan = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Dice();
        }

/*------------------------------------------------------------------------------------------------------------------*/
        
        System.out.println("How many players are participating?");
        
        //While loop used to validate user input for player count, and ask for it again if it's not valid
        while (true) {
        	boolean isNumber = true;
        	
        	try {
        		playerCount = Integer.parseInt(scan.nextLine());
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Please enter a number");
        		isNumber = false;
        	}
        	
        	if (isNumber == true) {
        		
        		try {
    		        if (playerCount > 6) {
    		        	throw new ArithmeticException("No more than 6 players can play.");
    		        }
    		        
    		        if (playerCount < 2) {
    		        	throw new ArithmeticException("At least 2 players are required.");
    		        }
    		        
    		        break;
                }
                catch (Exception e) {
    			    System.out.println("Please enter a number from 2 to 6.");
                }
        		
        	}
        	
            
           
        }   
        
        //Instructions on how to save dice
        System.out.println("When asked which dice to save, please enter the die numbers you want \nto keep separated by a space, or just press Enter to save no dice.");
        
        //Create Scorecards for every player as well as initialize them
        scorecards = new Scorecard[playerCount];
        for (int i = 0; i < scorecards.length; i++) {
        	scorecards[i] = new Scorecard();
        }
        
/*------------------------------------------------------------------------------------------------------------------*/
        
        //Loop 13 times - only 13 turns are possible in a game of Yahtzee
        for (int t = 1; t <= 13; t++) {
        System.out.println("TURN " + t);
        	
        	//Loop for however many players there are
        	for (int p = 0 ; p < playerCount; p++) {
        		System.out.println("Player " + (p + 1) + ", it is your turn");
        		
        		//Display current player's scorecard
        		scorecards[p].displayCurrentScores();
        		
        		//Loop up to 3 times, or break if they save all 5 dice
        		for(int i = 1; i <= 3; i++) {
        			
        			//If this is the first roll of the turn for this player, makes sure no dice are saved
        			if (i == 1) {
        				for (int j = 0; j < savedDice.length; j++) {
        					savedDice[j] = false;
        					//System.out.println("reset"); 
        				}
        			}
        			
        			//End the rolling if the player has saved all 5 dice.
        			if (savedDice[0] == true && savedDice[1] == true && savedDice[2] == true && savedDice[3] == true && savedDice[4] == true) {
        				break;
        			}
        			
        			//Rolls the unsaved dice
        			for (int s = 0; s < savedDice.length; s++) {
        				if (savedDice[s] == false) {
        					diceArray[s].Roll();
        				}
        			}
        			
        			SelectionSort(diceArray);
        			DisplayDiceValues(diceArray);
        			
        			
        			if (i != 3) { ChooseDice(savedDice, scan); }
        		}
        		
        		System.out.println("\nHere are you're scoring options. X means you can only put a zero.");
      
        		//Display possible scores based on dice array
        		scorecards[p].currentEligibleScores(diceArray);
        		
        		//Ask for player input on which score to keep	
        		System.out.println("Please select which score you'd like to register");
        		
        		//Validates user input of score category and saves their selection
        		categorySelection = ChooseScore(p, scorecards, scan);
        		zeroOverScore = ZeroOrDice(p, scorecards, categorySelection, scan);
        		
        		//Saves chosen score to players scorecard
        		scorecards[p].saveScoreSelection(categorySelection, zeroOverScore);
        		
        		System.out.println(zeroOverScore);
        		System.out.println(categorySelection);
        	}
        	
        }
        
        System.out.println("And that's the end of the game!!!\n\n\n");
        
        //Display everyone's total score
        for (int i = 0; i < scorecards.length; i++) {
        	System.out.println("Player " + (i + 1) + ", your score is " + scorecards[i].totalScore());
        }
        
        //Determine winner    
        int winningPlayer = 0;

        for (int i = 1; i < scorecards.length; i++) {
        	
        	//Just in case of a tie, "flips a coin" for who has the higher score. Highly unlikely to happen.
        	if (scorecards[i].totalScore() == scorecards[winningPlayer].totalScore()) {
        		int coin;
        		Random rand = new Random();
                coin = rand.nextInt(1000) % 2;
                
                if (coin == 0) {
                	winningPlayer = i;
                }
        	} 
        	else if (scorecards[i].totalScore() > scorecards[winningPlayer].totalScore()) {
        		winningPlayer = i;
        	}
        		
        }
        
/* ------------------------------------------- */
/*          THIS SECTION IS FOR TESTING        */

        diceArray[0].Roll();
        System.out.println(diceArray[0].value);

        savedDice = ChooseDice(savedDice, scan);
        
        //Display savedDice array for testing
        for (int i = 0; i < savedDice.length; i++) {
                System.out.println(savedDice[i]);
        }

        
/* ------------------------------------------- */
    
        scan.close();
		        
    }

    
	
	
	
    //Methods

	//Handles players saving dice during their turn
    private static boolean[] ChooseDice(boolean[] boolArray, Scanner scanner) {
    	
        //Initialization of variables
        boolean illegal = true;
        boolean outOfBounds = false;
        
        //Initialize boolArray all to false (no dice are saved)
        for (int i = 0; i < boolArray.length; i++) {
            boolArray[i] = false;
        }
        
        //Loop to make sure user input is legal; only loops if user input is not able to be accepted
        while (illegal) {
            //Resets variables so it can exit loop if input is accepted
        	illegal = false;
            outOfBounds = false;
            
            //Asks for input and saves it
            System.out.println("Which dice would you like to keep?");
            String input = scanner.nextLine();
            String[] boolArrayInt = input.split(" ");

            //Resets boolArray in case mistakes were made
            for (int i = 0; i < boolArray.length; i++) {
            	boolArray[i] = false;
            }
            
            //If user input is empty, don't save any dice and break loop
            if (input.isEmpty()) {
            	for (int i = 0; i < boolArray.length; i++) {
            		boolArray[i] = false;
            	}
            	break;
            }
            
            //Try statement catches any numbers less than 1 or greater than 5, due to the array size constraint
            try {
            	//Takes user input numbers of 1-5 and sets those corresponding dice in boolArray to be true (saved)
                for (int i = 0; i < boolArrayInt.length; i++) {
                    boolArray[Integer.parseInt(boolArrayInt[i]) - 1] = true;
                    
                }
            }
            catch (Exception e){
            	System.out.println("Please only enter numbers from 1 to 5, or press Enter to save none.");
            	illegal = true;
            	outOfBounds = true;
            }
            
            if (!outOfBounds) {
	
            	try {
            		//For loop for validating user input
    	            for (int i = 0; i < boolArray.length; i++) {
    	               
    	                //Checks if any numbers are the same
    	                for (int j = boolArrayInt.length - 1; j > i; j--) {
    	                    if (Integer.parseInt(boolArrayInt[i]) == Integer.parseInt(boolArrayInt[j])) {
    	                        illegal = true;
    	                        throw new Exception("Duplicate die saves"); 
    	                    }
    	                }
    	            }
	            }
            	catch (Exception e) {
	            	System.out.println("You cannot save the same die more than once.");
	            }
	            
            }
	            
        }
        
        return boolArray;
    }
    
    //Handles the player selecting a scoring category
    private static int ChooseScore(int player, Scorecard[] scorecards, Scanner scan) {
    	boolean isValid = true;
    	int selection = -1;
		do {
					
			String userInput = scan.nextLine();
			
			//Validates it's an integer
			try {
				selection = Integer.parseInt(userInput);
				isValid = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter the number of one of the available categories.");
				isValid = false;
			}
			
			if (isValid) {
				
				//Validates it's a correct category number from 1 to 13
				if (selection >= 1 && selection <= 13) {
					
					//Validates if the selection is able to be scored with dice and/or with a zero
					if(scorecards[player].possible[selection] == true || scorecards[player].card[selection] == -1) {
    					isValid = true;
    					return selection;
    				}
					else {
						System.out.println("Please only select one of the available categories.");
						isValid = false;
					}
					
				}
				else {
					System.out.println("Please only enter a number from 1 to 13");
					isValid = false;
				}
		
			}
			
		} while (isValid == false);
		
		//In case something weird happens
		return -1;
    }
    
    //Sets boolean to determine if they are scoring with a zero or with their dice
    private static boolean ZeroOrDice(int player, Scorecard[] scorecard, int selection, Scanner scan) {
    	
    	//If player can choose either the eligible score or zero, allows them to choose.  Otherwise, default to zero
		boolean isZero;
		
		//Has choice
		
		if (scorecard[player].possible[selection] == true) {
			
			System.out.println("Would you like to record your score from the dice roll? ('No' means recording a zero instead) \n[y/n]");
			
			while (true) {
				String response;
				response = scan.nextLine();
				
				if (response.equals("y")) {
					isZero = false;
					break;
				}
				else if (response.equals("n")) {
					isZero = true;
					break;
				}
				else {
					System.out.println("Please enter a valid response");
				}
			}
		}
		//Has no choice
		else {
			System.out.println("Only zero is available");
			isZero = true;
		}
		
		return isZero;
    }
    
    //Selection sort for an array, specifically for an array of Dice
    private static void SelectionSort(Dice[] arr) {
    	
    	for (int j = 1; j < arr.length; ++j) {
    		
    		int temp = arr[j].value;
    		int i = j - 1;
    		
    		while ((i >= 0) && (arr[i].value >= temp)) {
    			arr[i + 1].value = arr[i].value;
    			i--;
    		}
    		
    		arr[i + 1].value = temp;
    	}
    }
    
    private static void DisplayDiceValues(Dice[] arr) {
    	
    	System.out.println("Your dice values are now:");
		for (int i = 0; i < 5; i++) {
			System.out.println("Die " + (i + 1) + ": " + arr[i].value);
		}
    }
    
}

