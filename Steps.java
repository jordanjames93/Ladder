import java.util.Scanner;
import java.util.TreeSet;

class Ladder {
	private int numSteps;
	private TreeSet<Integer> steps = new TreeSet<Integer>(); // Keeps the data sorted. Removes duplicates.
	private int largestGap = 0;
	private Scanner input = new Scanner(System.in);
	
	Ladder(int numSteps) {
		this.numSteps = numSteps;
	}
	
	private void getSteps() {
		System.out.println("Enter the " + numSteps + " step heights(number greater than 0): ");
		for(int i = 0; i < numSteps; i++) {
			// Check that input is a number
			if(!input.hasNextInt()) {
				input.next();
				i--;
				continue;
			}
			// check that the number is greater than 0
			int height = input.nextInt();
			if(height <= 0) {
				input.next();
				i--;
				continue;
			}
			// add to set
			steps.add(height);
		}
	}
	
	
//	private void findLargestGap() {
//		int currGap = 0;
//		for(int i = 1; i < steps.length - 1; i++) {
//			currGap = steps[i] - steps[i - 1];
//			if(currGap > largestGap) largestGap = currGap;
//		}
//	}
	
	private void findLargestGap() {
		int currGap = 0;
		Object [] stepsArray = steps.toArray();
		for(int i = 1; i < stepsArray.length; i++) {
			currGap = (int)stepsArray[i] - (int)stepsArray[i - 1];
			if(currGap > largestGap) largestGap = currGap;
		}
	}
	
	void putLargestGap() {
		getSteps();
		findLargestGap();
		System.out.println("The largest gap is " + largestGap + "cm");
	}
}

public class Steps {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many steps?");
		int numSteps = in.nextInt();
		Ladder lad = new Ladder(numSteps);
		lad.putLargestGap();
	}
}
