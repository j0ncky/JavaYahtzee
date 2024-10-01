import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee {
    public static void main(String[] args) {
        Dice[] diceArray = new Dice[5];
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Dice();
        }

        boolean[] players = new boolean[6];
        //int[] diceChoices = new int[5];

        Scanner scan = new Scanner(System.in);

        System.out.println("How many players are playing today?");
        int playerCount = scan.nextInt();

        for (int i = 0; i < playerCount; i++) {
            players[i] = true;
        }

        for (boolean b : players) {
            System.out.println(b);
        }



/* ------------------------------------------- */
/*          THIS SECTION IS FOR TESTING        */

        diceArray[0].Roll();
        System.out.println(diceArray[0].value);

        ChooseDice();

        scan.close();
/* ------------------------------------------- */
    
    }


    private static void ChooseDice() {
        Scanner scan = new Scanner(System.in);
        boolean illegal = true;
        boolean[] diceChoices = new boolean[5];
        for (int i = 0; i < diceChoices.length; i++) {
            diceChoices[i] = false;
        }
        
        while (illegal) {
            illegal = false;
            System.out.println("Which dice would you like to keep?");

            String input = scan.nextLine();
            String[] tempArray = input.split(" ");
            for (int i = 0; i < tempArray.length; i++) {
                diceChoices[Integer.parseInt(tempArray[i]] = true;
                
            }
            for (int i = 0; i < diceChoices.size(); i++) {
                if (diceChoices.get(i) == 0) {
                    diceChoices.remove(i);
                    System.out.println(diceChoices.get(i));
                }
            }
            diceChoices.trimToSize();
            
        
            //For loop for validating user input
            for (int i = 0; i < diceChoices.size(); i++) {
                
                //Checks if any numbers are the same
                for (int j = diceChoices.size() - 1; j > i; j--) {
                    if (diceChoices.get(i) == diceChoices.get(j)) {
                        illegal = true;
                        System.out.println("You cannot save the same die more than once.");
                    }
                }
                
                //Checks if any integers are smaller than 1 or greater than 5
                if (diceChoices.get(i) < 1 || diceChoices.get(i) > 5 ) {
                    illegal = true;
                    System.out.println("Please only input numbers from 1 to 5.");
                    break;
                }
                
            }
        }

        for (int i = 0; i < diceChoices.size(); i++) {
            System.out.println();
        }

        scan.close();
    }
}