import java.util.Scanner;

public class Yahtzee {
    
	//Main
	public static void main(String[] args) {
        
		//Initialization of variables
		boolean[] players = new boolean[6];
    	Dice[] diceArray = new Dice[5];
        boolean[] savedDice = new boolean[5];
        Scanner scan = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Dice();
        }

        
        System.out.println("How many players are playing today?");
        
        //While loop used to validate user input for player count
        while (true) {
        	int playerCount = 0;
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
    		        for (int i = 0; i < playerCount; i++) {
    		            players[i] = true;
    		        }
    		        
    		        if (playerCount < 2) {
    		        	throw new ArithmeticException("At least 2 players are required.");
    		        }
    		        
    		        break;
                }
                catch (Exception e) {
    			    System.out.println("Please enter a number from 2 to 6.");
    			    
    			    for (int i = 0; i < players.length; i++) {
    			    	players[i] = false;
    			    }
    			    
                }
        		
        	}
        	
            
           
        }
      
        
        
        for (boolean b : players) {
            System.out.println(b);
        }

		/* ------------------------------------------- */
		/*          THIS SECTION IS FOR TESTING        */
		
		        diceArray[0].Roll();
		        System.out.println(diceArray[0].value);
		
		        savedDice = ChooseDice(savedDice);
		        
		        //Display savedDice array for testing
		        for (int i = 0; i < savedDice.length; i++) {
		                System.out.println(savedDice[i]);
		        }
		
		        scan.close();
		/* ------------------------------------------- */
    
    }

    
	
	
	
    //Methods

    private static boolean[] ChooseDice(boolean[] boolArray) {
        //Initialization of variables
    	Scanner scan = new Scanner(System.in);
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
            String input = scan.nextLine();
            String[] boolArrayInt = input.split(" ");

            //Resets boolArray in case mistakes were made
            for (int i = 0; i < boolArray.length; i++) {
            	boolArray[i] = false;
            }
            
            //Try statement catches any numbers less than 1 or greater than 5, due to the array size constraint
            try {
            	//Takes user input numbers of 1-5 and sets those corresponding dice in boolArray to be true (saved)
                for (int i = 0; i < boolArrayInt.length; i++) {
                    boolArray[Integer.parseInt(boolArrayInt[i]) - 1] = true;
                    
                }
            }
            catch (Exception e){
            	System.out.println("Please only enter numbers from 1 to 5");
            	illegal = true;
            	outOfBounds = true;
            }
            
            if (!outOfBounds) {
	
	            //For loop for validating user input
	            for (int i = 0; i < boolArray.length; i++) {
	                
	                //Checks if any numbers are the same
	                for (int j = boolArrayInt.length - 1; j > i; j--) {
	                    if (Integer.parseInt(boolArrayInt[i]) == Integer.parseInt(boolArrayInt[j])) {
	                        illegal = true;
	                        System.out.println("You cannot save the same die more than once.");
	                        break;
	                    }
	                }
	                
	            }
	            
            }
	            
        }
        
        scan.close();
        
        return boolArray;
    }
}