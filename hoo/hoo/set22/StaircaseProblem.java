import java.util.*;

public class StaircaseProblem {

    // Function to find number of ways to reach the nth step
    public static int countWays(int n) {
        // If there are no steps, there are no ways to reach
        if (n == 0) return 0;

        // Array to store the number of ways to reach each step
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // 1 way to stay on the ground (0th step)
        dp[1] = 1; // 1 way to reach the first step

        // Fill dp array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The answer will be in dp[n] (ways to reach nth step)
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of steps in the staircase
        System.out.print("Enter the number of steps in the staircase: ");
        int n = scanner.nextInt();

        // Find the number of ways to reach the nth step
        int result = countWays(n);

        // Output the result
        System.out.println("Number of ways to reach the top: " + result);
    }
}
