import java.util.Arrays; 
import java.util.Scanner; 
public class Ceil { 
    public static float findCeil(float[] arr, float x) { 
        Arrays.sort(arr); 
        for (float num : arr) { 
            if (num >= x) { 
                return num; 
            } 
        } 
        return -1;   
    } 
    public static float findFloor(float[] arr, float x) { 
        Arrays.sort(arr); 
        float floor = -1; 
        for (int i = arr.length - 1; i >= 0; i--) { 
            if (arr[i] <= x) { 
                floor = arr[i]; 
                break; 
            } 
        } 
        return floor; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the number of elements in the array: "); 
        int n = sc.nextInt(); 
        float[] arr = new float[n]; 
        System.out.print("Enter the array elements: "); 
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextFloat(); 
        } 
        System.out.print("Enter the target value x: "); 
        float x = sc.nextFloat(); 
        float ceil = findCeil(arr, x); 
        float floor = findFloor(arr, x); 
        if (ceil != -1) { 
            System.out.println("Ceil of " + x + " is: " + ceil); 
        } else { 
            System.out.println("No Ceil found for " + x); 
        } 
        if (floor != -1) { 
            System.out.println("Floor of " + x + " is: " + floor); 
        } else { 
            System.out.println("No Floor found for " + x); 
        } 
    } 
} 
