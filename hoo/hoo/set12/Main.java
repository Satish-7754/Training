import java.util.Scanner; 
public class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the size of the array: "); 
        int n = scanner.nextInt(); 
        int[] arr = new int[n]; 
        System.out.println("Enter elements of the array:"); 
        for (int i = 0; i < n; i++) { 
            arr[i] = scanner.nextInt(); 
        } 
        int[] result = productArray(arr, n); 
        System.out.println("Product of array elements excluding each element:"); 
        for (int i = 0; i < n; i++) { 
            System.out.print(result[i] + " "); 
        } 
        scanner.close(); 
    } 
    public static int[] productArray(int[] arr, int n) { 
        int[] result = new int[n]; 
        int[] leftProd = new int[n]; 
        int[] rightProd = new int[n]; 
        leftProd[0] = 1; 
        for (int i = 1; i < n; i++) { 
            leftProd[i] = leftProd[i - 1] * arr[i - 1]; 
        } 
        rightProd[n - 1] = 1; 
        for (int i = n - 2; i >= 0; i--) { 
            rightProd[i] = rightProd[i + 1] * arr[i + 1]; 
        } 
        for (int i = 0; i < n; i++) { 
            result[i] = leftProd[i] * rightProd[i]; 
        } 
        return result; 
    } 
} 