import java.util.Scanner; 
import java.util.Stack; 
public class EqualSumStacks { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the number of elements in stack 1: "); 
        int n1 = scanner.nextInt(); 
        Stack<Integer> stack1 = new Stack<>(); 
        System.out.println("Enter the elements of stack 1:"); 
        for (int i = 0; i < n1; i++) { 
            stack1.push(scanner.nextInt()); 
        } 
        System.out.print("Enter the number of elements in stack 2: "); 
        int n2 = scanner.nextInt(); 
        Stack<Integer> stack2 = new Stack<>(); 
        System.out.println("Enter the elements of stack 2:"); 
        for (int i = 0; i < n2; i++) { 
            stack2.push(scanner.nextInt()); 
        } 
        System.out.print("Enter the number of elements in stack 3: "); 
        int n3 = scanner.nextInt(); 
        Stack<Integer> stack3 = new Stack<>(); 
        System.out.println("Enter the elements of stack 3:"); 
        for (int i = 0; i < n3; i++) { 
            stack3.push(scanner.nextInt()); 
        } 
        System.out.println("Maximum equal sum among the 3 stacks: " + 
findMaxEqualSum(stack1, stack2, stack3)); 
        scanner.close(); 
    } 
    public static int findMaxEqualSum(Stack<Integer> stack1, Stack<Integer> stack2, 
Stack<Integer> stack3) { 
        int sum1 = getSum(stack1); 
        int sum2 = getSum(stack2); 
        int sum3 = getSum(stack3); 
        while (sum1 != sum2 || sum2 != sum3) { 
            if (sum1 > sum2 && sum1 > sum3) { 
                sum1 -= stack1.pop(); 
            } else if (sum2 > sum1 && sum2 > sum3) { 
                sum2 -= stack2.pop(); 
            } else { 
                sum3 -= stack3.pop(); 
            } 
            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) { 
                return 0;   
            } 
        } 
        return sum1; 
    } 
    private static int getSum(Stack<Integer> stack) { 
        int sum = 0; 
        for (int num : stack) { 
            sum += num; 
        } 
        return sum; 
    } 
} 