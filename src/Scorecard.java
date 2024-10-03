
public class Scorecard {

	int[] card = new int[13];
	boolean[] possible = new boolean[13];
	
	public void displayEligibleScores(int[] dice) {
		for (int i = 0; i < possible.length; i++) {
			possible[i] = false;
		}
		for (int i = 0; i < possible.length; i++) {
			System.out.println(possible[i]);
		}
	}
}