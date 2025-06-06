import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class RemoveDuplicatesFromLinkedList {

    public static Node removeDuplicates(Node head) {
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                // Duplicate found, skip this node
                prev.next = current.next;
            } else {
                // First occurrence, add to HashSet and move prev
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Linked list is empty.");
            scanner.close();
            return;
        }

        System.out.println("Enter the elements of the linked list:");
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Original Linked List: ");
        printList(head);

        head = removeDuplicates(head);

        System.out.print("Linked List after removing duplicates: ");
        printList(head);

        scanner.close();
    }
}