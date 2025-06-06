import java.util.PriorityQueue; 
import java.util.Scanner; 
public class MinConnectionCost { 
    public static int totalConnectionCost(int[] lengths) { 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        for (int length : lengths) { 
            minHeap.add(length); 
        } 
        int totalCost = 0; 
        while (minHeap.size() > 1) { 
            int first = minHeap.poll();  // Smallest 
            int second = minHeap.poll(); // Second smallest 
            int cost = first + second; 
            totalCost += cost; 
            minHeap.add(cost); 
        } 
        return totalCost; 
    } 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the number of ropes: "); 
        int n = scanner.nextInt(); 
        int[] lengths = new int[n]; 
        System.out.println("Enter the lengths of the ropes:"); 
        for (int i = 0; i < n; i++) { 
            lengths[i] = scanner.nextInt(); 
        } 
        int cost = totalConnectionCost(lengths); 
        System.out.println("Total Cost = " + cost); 
    } } 
