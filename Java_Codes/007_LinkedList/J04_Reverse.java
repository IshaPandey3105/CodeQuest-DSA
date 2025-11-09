// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class J04_Reverse {

    //  Method 1: Recursive approach
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //  Method 2: Iterative approach using 3 pointers
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;   // store next node
            curr.next = prev;   // reverse current link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
        }
        return prev; // new head
    }

    //  Main method to test both
    public static void main(String[] args) {
        // Create sample linked list: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        J04_Reverse obj = new J04_Reverse();

        System.out.println("Original List:");
        printList(head);

        // Recursive reverse
        ListNode rev1 = obj.reverseListRecursive(head);
        System.out.println("\nReversed (Recursive):");
        printList(rev1);

        // Re-reverse using iterative method (to get back original)
        ListNode rev2 = obj.reverseListIterative(rev1);
        System.out.println("\nReversed Again (Iterative):");
        printList(rev2);
    }

    // Helper to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " : ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

