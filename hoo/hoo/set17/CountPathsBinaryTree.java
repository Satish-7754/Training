import java.util.Scanner;
class Node { 
    int data; 
    Node left, right; 
    Node(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
public class CountPathsBinaryTree { 
    public static int countPaths(Node root) { 
        return countPathsUtil(root, 0); 
    } 
    public static int countPathsUtil(Node root, int currentSum) { 
        if (root == null) { 
            return 0; 
        } 
        currentSum += root.data; 
        if (root.left == null && root.right == null) { 
            return 1; 
        } 
        return countPathsUtil(root.left, currentSum) + countPathsUtil(root.right, currentSum); 
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
            root = insert(root, val);  
        } 
        int totalPaths = countPaths(root); 
        System.out.println("Total number of root-to-leaf paths: " + totalPaths); 
    } 
}