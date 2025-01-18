import java.util.Scanner;

public class AthleteRaceResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double t1 = readInt(scanner, "Enter the first time (in seconds): ");
        double t2 = readInt(scanner, "Enter the second time (in seconds): ");
        double t3 = readInt(scanner, "Enter the third time (in seconds): ");

        processAndDisplayResults(t1, t2, t3);

        scanner.close();
    }

    /**
     * Reads an integer from the user and verifies that it is within the acceptable range.
     *
     * @param scanner   Scanner object for reading input
     * @param prompt    Text to display to the user
     * @return          A valid integer within the specified range
     */
    private static int readInt(Scanner scanner, String prompt) {
        int number = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt(); // Read the integer
                return number; // Return the valid integer
            } else {
                System.out.println("Please enter an integer only.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    /**
     * Function to sort three times and their corresponding attempt numbers in ascending order.
     * The function determines the smallest, middle, and largest times along with their respective
     * attempt numbers and displays the results in a readable format.
     *
     * @param t1 Time of the first attempt
     * @param t2 Time of the second attempt
     * @param t3 Time of the third attempt
     */
    public static void processAndDisplayResults(double t1, double t2, double t3) {
        // Initialize variables for minimum, middle, and maximum times and their attempts
        double minTime = t1, midTime = t2, maxTime = t3;
        int minAttempt = 1, midAttempt = 2, maxAttempt = 3;

        // Compare to determine the correct order of times
        if (t1 > t2) {
            // Swap t1 and t2
            minTime = t2;
            midTime = t1;
            minAttempt = 2;
            midAttempt = 1;
        }

        if (midTime > t3) {
            // Swap midTime (currently max between t1 and t2) with t3
            maxTime = midTime;
            midTime = t3;
            maxAttempt = midAttempt;
            midAttempt = 3;
        }

        if (minTime > midTime) {
            // Swap minTime and midTime to maintain correct order after any previous adjustments
            double tempTime = minTime;
            minTime = midTime;
            midTime = tempTime;

            int tempAttempt = minAttempt;
            minAttempt = midAttempt;
            midAttempt = tempAttempt;
        }

        System.out.println("The sorted times and their corresponding attempts are:");
        System.out.printf("%.2f sec (Attempt %d)\n%.2f sec (Attempt %d)\n%.2f sec (Attempt %d)",
                        minTime, minAttempt, midTime, midAttempt, maxTime, maxAttempt);
    }
}
