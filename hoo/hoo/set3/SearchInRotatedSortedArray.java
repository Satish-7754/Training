import java.util.Scanner;

class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // If target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // The right half is sorted
                // If target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the target element:");
        int target = scanner.nextInt();
        int result = search(nums, target);
        if (result != -1) {
            System.out.println("Target element found at index: " + result);
        } else {
            System.out.println("Target element not found in the array.");
        }
        scanner.close();
    }
}