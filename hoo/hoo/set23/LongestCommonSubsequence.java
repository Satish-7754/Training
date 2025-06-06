import java.util.Scanner;

public class LongestCommonSubsequence {

    // Function to find the length of the LCS
    public static int[][] computeLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, increment the length
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, take the maximum of left or top cell
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    // Function to reconstruct the LCS string from the dp table
    public static String reconstructLCS(String str1, String str2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();
        int i = str1.length();
        int j = str2.length();

        // Start from bottom-right and move up to reconstruct the sequence
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                // Move in the direction of the larger value
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // The sequence is built in reverse
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // Compute the dp table
        int[][] dp = computeLCS(str1, str2);

        // Get the LCS string
        String lcs = reconstructLCS(str1, str2, dp);

        // Output the result
        System.out.println("Length of LCS: " + dp[str1.length()][str2.length()]);
        System.out.println("Longest Common Subsequence: " + lcs);

        scanner.close();
    }
}

