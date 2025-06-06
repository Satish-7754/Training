import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Scanner; 
public class Program7b { 
    public static void reverseQueue(Queue<Integer> q) { 
        if (q.isEmpty()) { 
            return; 
        } 
        int front = q.poll(); 
        reverseQueue(q); 
        q.offer(front); 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of elements in queue: "); 
        int n = sc.nextInt(); 
        Queue<Integer> queue = new LinkedList<>(); 
        System.out.print("Enter queue elements: "); 
        for (int i = 0; i < n; i++) { 
            queue.offer(sc.nextInt()); 
        } 
        System.out.print("Original Queue: "); 
        System.out.println(queue); 
        reverseQueue(queue); 
        System.out.print("Reversed Queue: "); 
        System.out.println(queue); 
    } 
}