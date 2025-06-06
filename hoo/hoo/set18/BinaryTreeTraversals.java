import java.util.Scanner; 
class Node { 
    int data; 
    Node left, right; 
    Node(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
public class BinaryTreeTraversals { 
    public static void inorder(Node root) { 
        if (root != null) { 
            inorder(root.left); 
            System.out.print(root.data + " "); 
            inorder(root.right); 
        } 
    } 
    public static void preorder(Node root) { 
        if (root != null) { 
            System.out.print(root.data + " "); 
            preorder(root.left); 
            preorder(root.right); 
        } 
    } 
    public static void postorder(Node root) { 
        if (root != null) { 
            postorder(root.left); 
            postorder(root.right); 
            System.out.print(root.data + " "); 
        } 
    } 
    public static Node insert(Node root, int key) { 
        if (root == null) return new Node(key); 
        if (key < root.data) 
            root.left = insert(root.left, key); 
        else 
            root.right = insert(root.right, key); 
        return root; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Node root = null; 
        System.out.print("Enter number of nodes: "); 
        int n = sc.nextInt(); 
        System.out.println("Enter " + n + " node values:"); 
        for (int i = 0; i < n; i++) { 
            int val = sc.nextInt(); 
            root = insert(root, val); // building a BST for simplicity 
        } 
        System.out.print("\nInorder Traversal: "); 
        inorder(root); 
        System.out.print("\nPreorder Traversal: "); 
        preorder(root); 
        System.out.print("\nPostorder Traversal: "); 
        postorder(root); 
    } 
} 
