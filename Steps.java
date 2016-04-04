import java.util.Scanner;

class Ladder {
	private int numSteps;
	private int[] steps;
	private int largestGap = 0;
	private Scanner input = new Scanner(System.in);
	
	Ladder(int numSteps) {
		this.numSteps = numSteps;
		steps = new int[numSteps];
	}
	
	private void getSteps() {
		System.out.println("Enter the " + numSteps + " step heights: ");
		for(int i = 0; i < steps.length; i++) {
			steps[i] = input.nextInt();
		}
	}
	
	private void findLargestGap() {
		int currGap = 0;
		for(int i = 1; i < steps.length - 1; i++) {
			currGap = steps[i] - steps[i - 1];
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
