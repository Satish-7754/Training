import java.util.*;

public class SortAndRemoveDuplicates {

    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int uniqueIndex = 1; // First element is always unique

        // Traverse through the array and find unique elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[uniqueIndex] = arr[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex; // Return the number of unique elements
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Remove duplicates
        int uniqueCount = removeDuplicates(arr);

        // Output the sorted array after removing duplicates
        System.out.print("Sorted array after removing duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


