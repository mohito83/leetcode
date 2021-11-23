package src.main.java.linkedlist;

public class RemoveDuplicates {
    void removeDuplicates(Node head) {
        Node n = head;
        while (n!=null && n.next != null) {
            if (n.val == n.next.val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void printList(Node head) {
        Node current = head;
        while (current!= null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static  void main (String[] args) {
        Node n = new Node(1);
        Node head = n;
        Node current = head;
        n = new Node(2);
        current.next = n;
        current = current.next;
        n = new Node(2);
        current.next = n;
        current = current.next;
        n = new Node(4);
        current.next = n;
        current = current.next;
        n = new Node(3);
        current.next = n;
        current = current.next;
        n = new Node(3);
        current.next = n;
        current = current.next;
        n = new Node(3);
        current.next = n;
        current = current.next;
        n = new Node(6);
        current.next = n;
        current = current.next;


        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println("Original List: ");
        rd.printList(head);

        System.out.println("After removing duplicates: ");
        rd.removeDuplicates(head);
        rd.printList(head);
    }
}
