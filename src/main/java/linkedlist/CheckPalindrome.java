package src.main.java.linkedlist;

public class CheckPalindrome {
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        // createa reverse linked list of orginal
        Node reverse = null, n = head;
        while (n != null) {
            Node x = new Node(n.val);

            if (reverse == null) {
                reverse = x;
            } else {
                x.next = reverse;
                reverse = x;
            }

            n = n.next;
        }

        // compare the original and reversed linkedlists
        n = head;
        while (reverse != null) {
            if (reverse.val != n.val) {
                return false;
            }
            n = n .next;
            reverse = reverse.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(1);

        CheckPalindrome cp =new CheckPalindrome();

        System.out.println("Is linked list a palindrome? " + cp.isPalindrome(n));
    }
}
