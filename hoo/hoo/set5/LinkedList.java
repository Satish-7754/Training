import java.util.Scanner; 
class LinkedList { 
    Node head;   
    static class Node { 
        int data; 
        Node next; 
        Node(int data) { 
            this.data = data; 
            this.next = null; 
        } 
    } 
    public void append(int data) { 
        Node newNode = new Node(data); 
        if (head == null) { 
            head = newNode; 
            return; 
        } 
        Node last = head; 
        while (last.next != null) { 
            last = last.next; 
        } 
        last.next = newNode; 
    } 
    public void reverse() { 
        Node prev = null; 
        Node current = head; 
        Node next = null; 
        while (current != null) { 
            next = current.next;  
            current.next = prev;  
            prev = current;       
            current = next; 
        } 
        head = prev;  
    } 
    public void printList() { 
        Node temp = head; 
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        LinkedList list = new LinkedList(); 
        System.out.print("Enter the number of elements in the linked list: "); 
        int n = sc.nextInt(); 
        System.out.println("Enter the elements:"); 
        for (int i = 0; i < n; i++) { 
            int data = sc.nextInt(); 
            list.append(data); 
        } 
        System.out.print("Original Linked List: "); 
        list.printList(); 
        list.reverse(); 
        System.out.print("Reversed Linked List: "); 
        list.printList(); 
    } 
}
