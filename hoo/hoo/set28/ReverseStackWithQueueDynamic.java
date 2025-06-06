import java.util.*;

public class ReverseStackWithQueueDynamic {

    // Reverses the given stack using one queue
    public static void reverseStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Move all elements from stack to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 2: Move them back from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.println("Enter stack elements (end with -1):");
        while (true) {
            int x = sc.nextInt();
            if (x == -1) break;
            st.push(x);
        }

        System.out.println("Original stack (bottom→top): " + st);
        reverseStack(st);
        System.out.println("Reversed stack (bottom→top): " + st);
    }
}