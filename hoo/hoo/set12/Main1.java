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
        if (data < root.data) 
            root.left = insertRec(root.left, data); 
        else if (data > root.data) 
            root.right = insertRec(root.right, data); 
        return root; 
    } 
    public void printLeftNodes() { 
        printLeftNodesRec(root); 
    } 
    private void printLeftNodesRec(Node root) { 
        if (root != null) { 
            if (root.left != null) { 
                System.out.print(root.left.data + " "); 
            } 
            printLeftNodesRec(root.left); 
            printLeftNodesRec(root.right); 
        } 
    } 
} 
class Main1 { 
    public static void main(String[] args) { 
        BinarySearchTree bst = new BinarySearchTree(); 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter numbers for BST (type 'done' to finish):"); 
        while (true) { 
            String input = scanner.nextLine(); 
            if (input.equalsIgnoreCase("done")) break; 
            try { 
                int value = Integer.parseInt(input); 
                bst.insert(value); 
            } catch (NumberFormatException e) { 
                System.out.println("Invalid input. Please enter a valid integer."); 
            } 
        } 
        System.out.println("\nLeft nodes of the BST:"); 
        bst.printLeftNodes(); 
        scanner.close(); 
    } 
}