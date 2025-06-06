import java.util.Scanner;

public class UniqueElementInSortedArray {

    // Function to find the element that occurs only once
    public static int findUniqueElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even, if it's odd, adjust it to be even
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair of mid is the same, if so move right half
            if (arr[mid] == arr[mid + 1]) {
                left = mid + 2;  // Move right
            } else {
                right = mid;  // Move left
            }
        }

        // After binary search, left should be at the unique element
        return arr[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        // Handle edge case when the array has no elements
        if (n == 0) {
            System.out.println(2);
            return;
        }

        int[] arr = new int[n];

        // Input elements of the array (sorted)
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // If all elements appear twice, return 2
        if (arr.length % 2 == 0) {
            System.out.println(2);
        } else {
            // Find the unique element
            int result = findUniqueElement(arr);
            System.out.println("The element that occurs only once is: " + result);
        }
    }
}
