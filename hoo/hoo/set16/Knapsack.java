import java.util.Scanner; 
public class Knapsack { 
    public static int knapsack(int W, int[] weights, int[] values, int n) { 
        int[][] dp = new int[n + 1][W + 1]; 
        for (int i = 0; i <= n; i++) { 
            for (int w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) { 
                    dp[i][w] = 0; 
                } else if (weights[i - 1] <= w) { 
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]); 
                } else { 
                    dp[i][w] = dp[i - 1][w]; 
                } 
            } 
        } 
        return dp[n][W]; 
    } 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the number of items: "); 
        int n = scanner.nextInt(); 
        System.out.print("Enter the capacity of the knapsack: "); 
        int W = scanner.nextInt(); 
        int[] weights = new int[n]; 
        int[] values = new int[n]; 
        System.out.println("Enter the weights and values of the items:"); 
        for (int i = 0; i < n; i++) { 
            System.out.print("Weight of item " + (i + 1) + ": "); 
            weights[i] = scanner.nextInt(); 
            System.out.print("Value of item " + (i + 1) + ": "); 
            values[i] = scanner.nextInt(); 
        } 
        int maxValue = knapsack(W, weights, values, n); 
        System.out.println("Maximum value that can be obtained: " + maxValue); 
 
        scanner.close(); 
    } 
} 