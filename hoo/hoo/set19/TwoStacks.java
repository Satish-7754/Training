import java.util.Scanner;

public class TwoStacks {
    private int[] arr;
    private int top1, top2, size;

    public TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    // Push for Stack 1
    public void push1(int data) {
        if (top1 < top2 - 1) {
            arr[++top1] = data;
            System.out.println("Pushed to Stack 1: " + data);
        } else {
            System.out.println("Stack Overflow for Stack 1!");
        }
    }

    // Push for Stack 2
    public void push2(int data) {
        if (top1 < top2 - 1) {
            arr[--top2] = data;
            System.out.println("Pushed to Stack 2: " + data);
        } else {
            System.out.println("Stack Overflow for Stack 2!");
        }
    }

    // Pop for Stack 1
    public void pop1() {
        if (top1 >= 0) {
            System.out.println("Popped from Stack 1: " + arr[top1--]);
        } else {
            System.out.println("Stack 1 is Empty!");
        }
    }

    // Pop for Stack 2
    public void pop2() {
        if (top2 < size) {
            System.out.println("Popped from Stack 2: " + arr[top2++]);
        } else {
            System.out.println("Stack 2 is Empty!");
        }
    }

    // Peek (Top) for Stack 1
    public void top1() {
        if (top1 >= 0) {
            System.out.println("Top of Stack 1: " + arr[top1]);
        } else {
            System.out.println("Stack 1 is Empty!");
        }
    }

    // Peek (Top) for Stack 2
    public void top2() {
        if (top2 < size) {
            System.out.println("Top of Stack 2: " + arr[top2]);
        } else {
            System.out.println("Stack 2 is Empty!");
        }
    }

    // Check if Stack 1 is empty
    public void isEmpty1() {
        System.out.println(top1 == -1 ? "Stack 1 is Empty" : "Stack 1 is NOT Empty");
    }

    // Check if Stack 2 is empty
    public void isEmpty2() {
        System.out.println(top2 == size ? "Stack 2 is Empty" : "Stack 2 is NOT Empty");
    }

    // Display Stack 1
    public void display1() {
        if (top1 == -1) {
            System.out.println("Stack 1 is Empty!");
        } else {
            System.out.print("Stack 1: ");
            for (int i = 0; i <= top1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Display Stack 2
    public void display2() {
        if (top2 == size) {
            System.out.println("Stack 2 is Empty!");
        } else {
            System.out.print("Stack 2: ");
            for (int i = size - 1; i >= top2; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Main driver (menu)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array to use for both stacks: ");
        int n = sc.nextInt();
        TwoStacks stacks = new TwoStacks(n);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Push to Stack 1");
            System.out.println("2. Push to Stack 2");
            System.out.println("3. Pop from Stack 1");
            System.out.println("4. Pop from Stack 2");
            System.out.println("5. Top of Stack 1");
            System.out.println("6. Top of Stack 2");
            System.out.println("7. Is Stack 1 Empty?");
            System.out.println("8. Is Stack 2 Empty?");
            System.out.println("9. Display Stack 1");
            System.out.println("10. Display Stack 2");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    stacks.push1(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter value: ");
                    stacks.push2(sc.nextInt());
                }
                case 3 -> stacks.pop1();
                case 4 -> stacks.pop2();
                case 5 -> stacks.top1();
                case 6 -> stacks.top2();
                case 7 -> stacks.isEmpty1();
                case 8 -> stacks.isEmpty2();
                case 9 -> stacks.display1();
                case 10 -> stacks.display2();
                case 0 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
