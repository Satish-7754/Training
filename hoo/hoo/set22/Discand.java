import java.util.*; 
public class Discand { 
    public static int distributeCandies(int[] rankings) { 
        int n = rankings.length; 
        int[] candies = new int[n]; 
        Arrays.fill(candies, 1);  
        for (int i = 1; i < n; i++) { 
            if (rankings[i] > rankings[i - 1]) { 
                candies[i] = candies[i - 1] + 1; 
            } 
        } 
        for (int i = n - 2; i >= 0; i--) { 
            if (rankings[i] > rankings[i + 1]) { 
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); 
            } 
        } 
        int totalCandies = Arrays.stream(candies).sum(); 
        return totalCandies; 
    } 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter number of students: "); 
        int n = scanner.nextInt(); 
        int[] rankings = new int[n]; 
        System.out.println("Enter rankings of students:"); 
        for (int i = 0; i < n; i++) { 
            rankings[i] = scanner.nextInt(); 
        } 
        int result = distributeCandies(rankings); 
        System.out.println("Minimum candies required: " + result); 
        scanner.close(); 
    } 
} 
