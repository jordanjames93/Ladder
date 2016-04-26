import java.util.Scanner;
import java.util.TreeSet;

class Ladder {
    private int numSteps;
    private TreeSet<Double> steps = new TreeSet<Double>(); // Keeps the data sorted. Removes duplicates.
    private double largestGap = 0;
    private Scanner input = new Scanner(System.in);

    Ladder(int numSteps) {
        this.numSteps = numSteps;
    }

    private void getSteps() {
        System.out.println("Enter the " + numSteps + " step heights(number greater than 0): ");
        for(int i = 0; i < numSteps; i++) {
            // Check that input is a number
            if(!input.hasNextDouble()) {
                input.next();
                i--;
                invalidInput();
                continue;
            }
            // check that the number is greater than 0
            double height = input.nextDouble();
            if(height <= 0) {
                i--;
                invalidInput();
                continue;
            }
            // add to set
            steps.add(height);
        }
    }

    private void findLargestGap() {
        double currGap = 0;
        // create an array and use the for loop as before. Some casting was necessary.
        Object [] stepsArray = steps.toArray();
        for(int i = 1; i < stepsArray.length; i++) {
            currGap = (double)stepsArray[i] - (double)stepsArray[i - 1];
            if(currGap > largestGap) largestGap = currGap;
        }
    }

    private void invalidInput() {
        System.out.println("Not a valid input. Go again");
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
