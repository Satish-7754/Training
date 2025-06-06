import java.util.Scanner; 
public class TripletCheckerDynamic { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the number of elements in the array:"); 
        int n = scanner.nextInt(); 
        int[] arr = new int[n]; 
        System.out.println("Enter the elements of the array:"); 
        for (int i = 0; i < n; i++) { 
            arr[i] = scanner.nextInt(); 
        } 
        checkTriplet(arr); 
    } 
    public static void checkTriplet(int[] arr) { 
        boolean found = false; 
        int length = arr.length; 
        for (int i = 0; i < length; i++) { 
            for (int j = i + 1; j < length; j++) { 
                for (int k = 0; k < length; k++) { 
                  if (k != i && k != j && arr[i] + arr[j] == arr[k]) { 
                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]); 
                        found = true; 
                        return; // Stop after finding the first triplet 
                    } 
                } 
            } 
        } 
        if (!found) { 
            System.out.println("Triplet not exists"); 
        } 
    }
}