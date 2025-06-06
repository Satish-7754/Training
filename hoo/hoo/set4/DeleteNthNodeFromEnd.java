//2 pointer 
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class DeleteNthNodeFromEnd {

    public static Node deleteNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node first = head;
        Node second = head;

        // Move 'first' pointer 'n' nodes ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                // n is greater than the number of nodes, no deletion possible
                return head;
            }
            first = first.next;
        }

        // If 'first' becomes null, it means we need to delete the head node
        if (first == null) {
            return head.next;
        }

        // Move both 'first' and 'second' pointers until 'first' reaches the end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // 'second' is now pointing to the node before the one to be deleted
        second.next = second.next.next;

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();

        if (numNodes == 0) {
            System.out.println("List is empty.");
            scanner.close();
            return;
        }

        System.out.print("Enter the elements of the LinkedList: ");
        Node head = new Node(scanner.nextInt());
        Node current = head;
        for (int i = 1; i < numNodes; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }

        System.out.print("Enter the position from the end to delete: ");
        int positionFromEnd = scanner.nextInt();

        System.out.print("Original List: ");
        printList(head);

        head = deleteNthFromEnd(head, positionFromEnd);

        System.out.print("List after deleting " + positionFromEnd + "th node from the end: ");
        printList(head);

        scanner.close();
    }
}