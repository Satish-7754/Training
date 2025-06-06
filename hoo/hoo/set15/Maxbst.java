import java.util.LinkedList; 
import java.util.Queue; 
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
    public int maxWidth() { 
        return getMaxWidth(root); 
    } 
    private int getMaxWidth(Node root) { 
        if (root == null) { 
            return 0; 
        } 
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root); 
        int maxWidth = 0; 
        while (!queue.isEmpty()) { 
            int levelWidth = queue.size(); 
            maxWidth = Math.max(maxWidth, levelWidth); 
            for (int i = 0; i < levelWidth; i++) { 
                Node node = queue.poll(); 
                if (node.left != null) { 
                    queue.add(node.left); 
                } 
                if (node.right != null) { 
                    queue.add(node.right); 
                } 
            } 
        } 
        return maxWidth; 
    } 
} 
class Maxbst { 
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
        int maxWidth = tree.maxWidth(); 
        System.out.println("Maximum width of the BST: " + maxWidth); 
        scanner.close(); 
    } 
}