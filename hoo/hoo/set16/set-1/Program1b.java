import java.util.*; 
public class Program1b{ 
    public static int findMin(int[] arr) { 
        int low = 0, high = arr.length - 1; 
        while (low < high) { 
            int mid = low + (high - low) / 2; 
            if (arr[mid] > arr[high]) { 
                low = mid + 1; 
            } else { 
                high = mid; 
            } 
        } 
        return arr[low]; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of elements: "); 
        int n = sc.nextInt(); 
        int[] arr = new int[n]; 
        System.out.print("Enter rotated sorted array: "); 
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt(); 
        int min = findMin(arr); 
        System.out.println("Minimum element: " + min); 
    } 
}