import java.util.Scanner;

public class Yahtzee {
    public static void main(String[] args) {
        Dice[] diceArray = new Dice[5];
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Dice();
        }

        boolean[] players = new boolean[6];
        Scanner scan = new Scanner(System.in);

        System.out.println("How many players are playing today?");

        for (int i = 0; i < scan.nextInt(); i++) {
            players[i] = true;
        }

        for (boolean b : players) {
            System.out.println(b);
        }
        diceArray[0].Roll();
        System.out.println(diceArray[0].value);


        scan.close();
    }

    private static void ChooseDice(Scanner scan) {
        System.out.println("Which dice would you like to keep?");
        
        String input = scan.nextLine();
        String[] diceChoices = input.split(" ");
        

    }
}

//For having the user choose which dice to keep

//String input = scanner.nextLine();    // get the entire line after the prompt 
//String[] numbers = input.split(" "); 