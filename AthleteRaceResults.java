import java.util.Scanner;

public class AthleteRaceResults {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read three times (in seconds)
        System.out.print("הכנס זמן ראשון (בשניות): ");
    double t1 = scanner.nextDouble();
        System.out.print("הכנס זמן שני (בשניות): ");
    double t2 = scanner.nextDouble();
        System.out.print("הכנס זמן שלישי (בשניות): ");
    double t3 = scanner.nextDouble();

    // Variables to hold the minimum, middle, and maximum times, and their attempt numbers
    double minTime, midTime, maxTime;
    int minAttempt, midAttempt, maxAttempt;

    // Determine the smallest time
        if (t1 <= t2 && t1 <= t3) {
        minTime = t1;
        minAttempt = 1;

        // Compare the remaining t2, t3
        if (t2 <= t3) {
            midTime = t2;
            midAttempt = 2;
            maxTime = t3;
            maxAttempt = 3;
        } else {
            midTime = t3;
            midAttempt = 3;
            maxTime = t2;
            maxAttempt = 2;
        }
    }
        else if (t2 <= t1 && t2 <= t3) {
        minTime = t2;
        minAttempt = 2;

        // Compare the remaining t1, t3
        if (t1 <= t3) {
            midTime = t1;
            midAttempt = 1;
            maxTime = t3;
            maxAttempt = 3;
        } else {
            midTime = t3;
            midAttempt = 3;
            maxTime = t1;
            maxAttempt = 1;
        }
    }
        else {
        // Otherwise t3 is the smallest
        minTime = t3;
        minAttempt = 3;

        // Compare the remaining t1, t2
        if (t1 <= t2) {
            midTime = t1;
            midAttempt = 1;
            maxTime = t2;
            maxAttempt = 2;
        } else {
            midTime = t2;
            midAttempt = 2;
            maxTime = t1;
            maxAttempt = 1;
        }
    }

    // Print times in ascending order, each with the attempt number
        System.out.printf("%.2f (ניסיון %d)\n", minTime, minAttempt);
        System.out.printf("%.2f (ניסיון %d)\n", midTime, midAttempt);
        System.out.printf("%.2f (ניסיון %d)\n", maxTime, maxAttempt);

        scanner.close();
}
}