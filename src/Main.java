import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumberFormat numberFormat = new DecimalFormat("0.000");
        String answer = "Y";
        int counter = 0;
        int totalBases = 0;
        int atBats;

        do {
            // At bats determines the number of elements in the array.
            System.out.print("Enter number of at bats: ");
            atBats = scan.nextInt();
            System.out.println();

            int[] resultOfAtBats = new int[atBats];

            for (int i = 0; i < resultOfAtBats.length; i++) {
                do {
                    System.out.print("Result for at-bat " + (i + 1) + ": ");
                    resultOfAtBats[i] = scan.nextInt();

                    // Calls method that validates user input.
                    validatesInput(resultOfAtBats[i]);

                } while (resultOfAtBats[i] < 0 || resultOfAtBats[i] > 4);
            }
            System.out.println();

            // Calls method to add the result of each at-bat.
            totalBases = getTotalBases(totalBases, resultOfAtBats);
            System.out.println("Slugging percentage: " + numberFormat.format((double) totalBases / atBats));

            // Calls method to count the number of non-zero inputs (hits).
            counter = getCounter(counter, resultOfAtBats);
            System.out.println("Batting average: " + numberFormat.format((double) counter / atBats));
            System.out.println();

            scan.nextLine();
            System.out.println("Another batter? (y/n): ");
            answer = scan.nextLine();
        } while (answer.contains("y"));
    }

    // Method below throws error when the input is not from range 0-4.
    private static void validatesInput(int resultOfAtBat) {
        if (resultOfAtBat < 0 || resultOfAtBat > 4) {
            System.out.println("Error: enter valid number of bases (0-4)");
        }
    }

    // Method below loops through each element in the array (resultOfAtBats) and adds them.
    // It goes through the array and adds the value in index 0 to value in index 1 and assigns
    // that value to totalBases.....it continues through loop until the end of the array is reached.
    private static int getTotalBases(int totalBases, int[] resultOfAtBats) {
        for (int i = 0; i < resultOfAtBats.length; i++) {
            totalBases = totalBases + resultOfAtBats[i];
        }
        return totalBases;
    }

    // Method below loops through each element in the array and checks if the element is not a zero.
    // If true it increments the counter. The counter is used to determine the number of hits, which is then
    // divided by the at-bats to get the batting average.
    private static int getCounter(int counter, int[] resultOfAtBats) {
        for (int i = 0; i < resultOfAtBats.length; i++) {
            if (resultOfAtBats[i] != 0) {
                counter++;
            }
        }
        return counter;
    }
}

