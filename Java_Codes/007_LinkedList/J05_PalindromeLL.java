// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class J05_PalindromeLL {

    //  Function to reverse the linked list (iterative using 3 pointers)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = head.next;

        while (nex != null) {
            curr.next = prev;
            prev = curr;
            curr = nex;
            nex = nex.next;
        }
        curr.next = prev;
        return curr; // new head
    }

    //  Function to check if linked list is palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // Step 1: Find middle (T2 = slow, T1 = fast)
        ListNode T1 = head;
        ListNode T2 = head;
        while (T1 != null && T1.next != null) {
            T2 = T2.next;
            T1 = T1.next.next;
        }

        // Step 2: Reverse second half
        ListNode Temp = reverseList(T2);

        // Step 3: Compare both halves
        T1 = head;
        T2 = Temp;
        while (T2 != null) {
            if (T1.val != T2.val)
                return false;
            T1 = T1.next;
            T2 = T2.next;
        }

        return true;
    }

    //  Test code for VS Code
    public static void main(String[] args) {
        // Example 1: Palindrome
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        // Example 2: Not Palindrome
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        J05_PalindromeLL obj = new J05_PalindromeLL();

        System.out.println("List 1:");
        printList(head1);
        System.out.println("Is Palindrome? " + obj.isPalindrome(head1));

        System.out.println("\nList 2:");
        printList(head2);
        System.out.println("Is Palindrome? " + obj.isPalindrome(head2));
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " : ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
