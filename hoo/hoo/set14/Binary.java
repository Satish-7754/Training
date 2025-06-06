import java.util.Scanner; 
class Node { 
    int data; 
    Node left, right; 
    public Node(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
class BinarySearchTree { 
    Node root; 
    public void insert(int data) { 
        root = insertRec(root, data); 
    } 
    private Node insertRec(Node root, int data) { 
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data) root.left = insertRec(root.left, data); 
        else if (data > root.data) root.right = insertRec(root.right, data); 
        return root; 
    } 
    public int height() { 
        return heightRec(root); 
    } 
    private int heightRec(Node node) { 
        if (node == null) return -1; 
        return Math.max(heightRec(node.left), heightRec(node.right)) + 1; 
    } 
    public void inorder() { 
        inorderRec(root); 
    } 
    private void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.data + " "); 
            inorderRec(root.right); 
        } 
    } 
} 
public class Binary { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BinarySearchTree tree = new BinarySearchTree(); 
        while (true) { 
            System.out.print("Enter a number (or 'exit' to stop): "); 
            String input = scanner.nextLine(); 
            if (input.equalsIgnoreCase("exit")) break; 
            try { 
                int value = Integer.parseInt(input); 
                tree.insert(value); 
            } catch (NumberFormatException e) { 
                System.out.println("Invalid input."); 
            } 
        } 
 
        System.out.println("\nIn-order traversal of the BST:"); 
        tree.inorder(); 
        System.out.println("\nHeight of the tree: " + tree.height()); 
        scanner.close(); 
    } 
} 