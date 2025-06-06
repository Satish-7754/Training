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
    public int widthAtLevel(Node root, int level) { 
        if (root == null) { 
            return 0; 
        } 
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root); 
        int currentLevel = 0; 
        int widthAtGivenLevel = 0; 
        while (!queue.isEmpty()) { 
            int nodeCount = queue.size(); 
            if (currentLevel == level) { 
                widthAtGivenLevel = nodeCount; 
            } 
            while (nodeCount-- > 0) { 
                Node currentNode = queue.poll(); 
                if (currentNode.left != null) { 
                    queue.add(currentNode.left); 
                } 
                if (currentNode.right != null) { 
                    queue.add(currentNode.right); 
                } 
            } 
            currentLevel++; 
            if (currentLevel > level) { 
                break; 
            } 
        } 
        return widthAtGivenLevel; 
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
} 
public class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BinarySearchTree tree = new BinarySearchTree(); 
        System.out.print("Enter the number of nodes to insert into the BST: "); 
        int n = scanner.nextInt(); 
        System.out.println("Enter the values for the BST nodes:"); 
        for (int i = 0; i < n; i++) { 
            int value = scanner.nextInt(); 
            tree.insert(value); 
        } 
        System.out.print("Enter the level at which to calculate the width: "); 
        int level = scanner.nextInt(); 
        int width = tree.widthAtLevel(tree.root, level); 
        System.out.println("Width of the BST at level " + level + " is: " + width); 
        scanner.close(); 
    } 
} 
