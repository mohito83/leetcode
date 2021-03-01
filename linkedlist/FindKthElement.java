package linkedlist;

public class FindKthElement {
    Node getKthElementFromEnd(Node head , int k) {
        if (head == null || head.next ==null) {
            return head;
        }

        Node current = head, runner = head;
        
        while(runner.next != null) {
            runner = runner.next;
            if (--k < 1) {
                current = current.next;
            }
        }

        return current;
    }

    void printList(Node head) {
        Node current = head;
        while (current!= null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    Node init() {
        Node n = new Node(1);
        Node head = n;
        Node current = head;
        n = new Node(2);
        current.next = n;
        current = current.next;
        n = new Node(3);
        current.next = n;
        current = current.next;
        n = new Node(4);
        current.next = n;
        current = current.next;
        n = new Node(5);
        current.next = n;
        current = current.next;
        n = new Node(6);
        current.next = n;
        current = current.next;
        return head;
    }

    public static void main(String[] args) {
        FindKthElement fke = new FindKthElement();
        Node head = fke.init();

        System.out.println("Original linked list: ");
        fke.printList(head);

        System.out.println(3+": element from end is: "+ fke.getKthElementFromEnd(head, 3).val);
    }
}
