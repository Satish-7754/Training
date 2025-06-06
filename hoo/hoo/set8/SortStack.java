import java.util.Scanner; 
import java.util.Stack; 
public class SortStack { 
    public static Stack<Integer> sortStack(Stack<Integer> input) { 
        Stack<Integer> tempStack = new Stack<>(); 
        while (!input.isEmpty()) { 
            int temp = input.pop(); 
            while (!tempStack.isEmpty() && tempStack.peek() > temp) { 
                input.push(tempStack.pop()); 
            } 
            tempStack.push(temp); 
        } 
        return tempStack; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Stack<Integer> stack = new Stack<>(); 
        System.out.print("Enter number of elements: "); 
        int n = sc.nextInt(); 
        System.out.print("Enter elements: "); 
        for (int i = 0; i < n; i++) { 
            stack.push(sc.nextInt()); 
        } 
        Stack<Integer> sorted = sortStack(stack); 
        System.out.print("Sorted Stack (top to bottom): "); 
        while (!sorted.isEmpty()) { 
            System.out.print(sorted.pop() + " "); 
        } 
    } 
} 
