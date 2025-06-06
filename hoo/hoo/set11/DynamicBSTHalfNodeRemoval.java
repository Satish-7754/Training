import java.util.Scanner; 
class Node { 
    int data; 
    Node left, right; 
    Node(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
public class DynamicBSTHalfNodeRemoval { 
    public static Node insert(Node root, int key) { 
        if (root == null) return new Node(key); 
        if (key < root.data) 
            root.left = insert(root.left, key); 
        else 
            root.right = insert(root.right, key); 
        return root; 
    } 
    public static Node removeHalfNodes(Node root) { 
        if (root == null) return null; 
        root.left = removeHalfNodes(root.left); 
        root.right = removeHalfNodes(root.right); 
        if (root.left == null && root.right != null) 
            return root.right; 
        if (root.left != null && root.right == null) 
            return root.left; 
        return root; 
    } 
    public static void inorder(Node root) { 
        if (root != null) { 
            inorder(root.left); 
            System.out.print(root.data + " "); 
            inorder(root.right); 
        } 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Node root = null; 
        System.out.println("Enter number of nodes to insert:"); 
        int n = sc.nextInt(); 
        System.out.println("Enter " + n + " values:"); 
        for (int i = 0; i < n; i++) { 
            int val = sc.nextInt(); 
            root = insert(root, val); 
        } 
        System.out.print("\nInorder before removing half nodes: "); 
        inorder(root); 
        root = removeHalfNodes(root); 
        System.out.print("\nInorder after removing half nodes: "); 
        inorder(root); 
    } 
}
