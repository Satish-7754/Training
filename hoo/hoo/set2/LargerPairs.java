import java.util.Arrays;
import java.util.Scanner;

public class LargerPairs {
    public static void findPairs(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.println("(" + arr[i] + "," + arr[j] + ")");
                count++;
            }
        }
        System.out.println("Total pairs: " + count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        findPairs(arr);
    }
}
