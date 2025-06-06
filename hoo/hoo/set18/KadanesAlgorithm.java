import java.util.Scanner; 
public class KadanesAlgorithm { 
    public static int maxSubArraySum(int[] arr) { 
        int maxSoFar = arr[0]; 
        int maxEndingHere = arr[0]; 
        for (int i = 1; i < arr.length; i++) { 
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]); 
            maxSoFar = Math.max(maxSoFar, maxEndingHere); 
        } 
        return maxSoFar; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of elements: "); 
        int n = sc.nextInt(); 
        int[] arr = new int[n]; 
        System.out.println("Enter array elements:"); 
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt(); 
        } 
        int maxSum = maxSubArraySum(arr); 
        System.out.println("Maximum Subarray Sum = " + maxSum); 
    } 
}