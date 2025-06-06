import java.util.*;

public class BFSTraversalBST {

    // Node class for BST
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Insert a new value into the BST
    public static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.data) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }

    // Breadth-First Search / Level Order Traversal
    public static void bfsTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Breadth-First Traversal (Level Order): ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = insert(root, value);
        }

        bfsTraversal(root);
    }
}
