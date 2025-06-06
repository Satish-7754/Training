import java.util.InputMismatchException;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    Node root;

    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    Node mirrorCopy(Node node) {
        if (node == null)
            return null;
        Node mirrored = new Node(node.data);
        mirrored.left = mirrorCopy(node.right);
        mirrored.right = mirrorCopy(node.left);
        return mirrored;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        int choice;
        int value;
        Node mirroredTree = null;

        do {
            System.out.println("\n===== BST Menu =====");
            System.out.println("1. Insert Node");
            System.out.println("2. Display Original Inorder");
            System.out.println("3. Create and Display Mirrored Tree");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            //try catch added
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                choice = -1; // Set to -1 to loop again
                sc.next(); // Consume the invalid input
                continue; // Restart the loop
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    try {
                        value = sc.nextInt();
                        tree.root = tree.insert(tree.root, value);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // consume the non-int input
                    }
                    break;
                case 2:
                    System.out.println("Original BST (Inorder):");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 3:
                    mirroredTree = tree.mirrorCopy(tree.root);
                    System.out.println("Mirrored BST (Inorder):");
                    tree.inorder(mirroredTree);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    if(choice != -1)
                        System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}