//iteration 
import java.util.Scanner; 
public class iteration { 
    static class Node { 
        int data; 
        Node next; 
        Node(int d) { data = d; next = null; } 
    } 
    public static boolean searchIterative(Node head, int target) { 
        Node curr = head; 
        while (curr != null) { 
            if (curr.data == target) return true; 
            curr = curr.next; 
        } 
        return false; 
    } 
    public static Node buildList(int[] vals) { 
        if (vals.length == 0) return null; 
        Node head = new Node(vals[0]), tail = head; 
        for (int i = 1; i < vals.length; i++) { 
            tail.next = new Node(vals[i]); 
            tail = tail.next; 
        } 
        return head; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of nodes: "); 
        int n = sc.nextInt(); 
        int[] vals = new int[n]; 
        System.out.print("Enter list elements: "); 
        for (int i = 0; i < n; i++) vals[i] = sc.nextInt(); 
        System.out.print("Enter target to search: "); 
        int target = sc.nextInt(); 
        Node head = buildList(vals); 
        boolean found = searchIterative(head, target); 
        System.out.println("Element " + target + 
            (found ? " found" : " not found") + " using Iteration."); 
    } 
} 
