import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        System.out.println("Pushed: " + x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack contents (top to bottom): " + q1);
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        Scanner sc = new Scanner(System.in);
        int choice, value;
        do {
            System.out.println("\n1. Push\n2. Pop\n3. Top\n4. Display\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1)
                        System.out.println("Popped: " + popped);
                    break;
                case 3:
                    int top = stack.top();
                    if (top != -1)
                        System.out.println("Top element: " + top);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}