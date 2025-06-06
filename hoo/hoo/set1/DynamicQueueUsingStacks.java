import java.util.Scanner; 
import java.util.Stack; 
class DynamicQueueUsingStacks { 
    Stack<Integer> stack1 = new Stack<>(); 
    Stack<Integer> stack2 = new Stack<>(); 
    public void enqueue(int data) { 
        stack1.push(data); 
        System.out.println("Enqueued: " + data); 
    } 
    public int dequeue() { 
        if (isEmpty()) { 
            System.out.println("Queue is empty!"); 
            return -1; 
        } 
        if (stack2.isEmpty()) { 
            while (!stack1.isEmpty()) { 
                stack2.push(stack1.pop()); 
            } 
        } 
        return stack2.pop(); 
    } 
    public boolean isEmpty() { 
        return stack1.isEmpty() && stack2.isEmpty(); 
    } 
    public void display() { 
        if (isEmpty()) { 
            System.out.println("Queue is empty!"); 
            return; 
        } 
        if (stack2.isEmpty()) { 
            while (!stack1.isEmpty()) { 
                stack2.push(stack1.pop()); 
            } 
        } 
        System.out.println("Queue contents (front to rear):"); 
        for (int i = stack2.size() - 1; i >= 0; i--) { 
            System.out.print(stack2.get(i) + " "); 
        } 
        System.out.println(); 
    } 
    public static void main(String[] args) { 
        DynamicQueueUsingStacks queue = new DynamicQueueUsingStacks(); 
        Scanner sc = new Scanner(System.in); 
        int choice, value; 
        do { 
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit"); 
            System.out.print("Enter your choice: "); 
            choice = sc.nextInt(); 
            switch (choice) { 
                case 1: 
                    System.out.print("Enter value to enqueue: "); 
                    value = sc.nextInt(); 
                    queue.enqueue(value); 
                    break; 
                case 2: 
                    int removed = queue.dequeue(); 
                    if (removed != -1) { 
                        System.out.println("Dequeued: " + removed); 
                    } 
                    break; 
                case 3: 
                    queue.display(); 
                    break; 
                case 4: 
                    System.out.println("Exiting..."); 
                    break; 
                default: 
                    System.out.println("Invalid choice."); 
            } 
        } while (choice != 4); 
        sc.close(); 
    } 
} 