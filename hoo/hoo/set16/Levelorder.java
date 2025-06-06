import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 
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
    public BinarySearchTree() { 
        root = null; 
    } 
    public void insert(int data) { 
        root = insertRec(root, data); 
    } 
    private Node insertRec(Node root, int data) { 
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data) { 
            root.left = insertRec(root.left, data); 
        } else if (data > root.data) { 
            root.right = insertRec(root.right, data); 
        } 
        return root; 
    } 
    public void reverseLevelOrder() { 
        if (root == null) { 
            return; 
        } 
        Queue<Node> queue = new LinkedList<>(); 
        Stack<Node> stack = new Stack<>(); 
        queue.add(root); 
        while (!queue.isEmpty()) { 
            Node node = queue.poll(); 
            stack.push(node); 
            if (node.right != null) { 
                queue.add(node.right); 
            } 
            if (node.left != null) { 
                queue.add(node.left); 
            } 
        } 
        while (!stack.isEmpty()) { 
            System.out.print(stack.pop().data + " "); 
        } 
    } 
} 
public class Levelorder { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BinarySearchTree tree = new BinarySearchTree(); 
        System.out.print("Enter the number of nodes in the BST: "); 
        int n = scanner.nextInt(); 
        System.out.println("Enter the elements of the BST:"); 
        for (int i = 0; i < n; i++) { 
            int value = scanner.nextInt(); 
            tree.insert(value); 
        } 
        System.out.println("Reverse level-order traversal of the BST:"); 
        tree.reverseLevelOrder(); 
        scanner.close(); 
    } 
} 