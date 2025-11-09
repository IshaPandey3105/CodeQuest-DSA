// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class J06_RandomPointer {

    // Step 1: Deep copy the linked list (without randoms)
    public Node deepCopy(Node head) {
        if (head == null) return null;

        Node newHead = new Node(head.val);
        Node T1 = head.next;
        Node T2 = newHead;

        while (T1 != null) {
            T2.next = new Node(T1.val);
            T1 = T1.next;
            T2 = T2.next;
        }
        return newHead;
    }

    // Step 2: Connect both lists alternatively (original → copy → original → copy …)
    public void connectBoth(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;

        while (t1 != null && t2 != null) {
            Node next1 = t1.next;
            Node next2 = t2.next;

            t1.next = t2;
            t2.next = next1;

            t1 = next1;
            t2 = next2;
        }
    }

    //  Step 3: Assign random pointers for copied nodes
    public void assignRandom(Node head, Node head2) {
        Node t1 = head;
        while (t1 != null) {
            Node t2 = t1.next;
            if (t1.random != null)
                t2.random = t1.random.next;
            if (t2.next != null)
                t1 = t2.next;
            else
                break;
        }
    }

    //  Step 4: Split the merged list into two separate lists
    public void split(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        while (t1 != null && t2 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if (t1 != null)
                t2.next = t1.next;
            t2 = t2.next;
        }
    }

    //  Main method to copy the list with random pointers
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: create deep copy
        Node head2 = deepCopy(head);
        // Step 2: join both linked lists (alternatively)
        connectBoth(head, head2);
        // Step 3: assign random pointers
        assignRandom(head, head2);
        // Step 4: split the linked lists
        split(head, head2);

        return head2;
    }

    // 🧪 Optional test (for VS Code)
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;

        a.random = c;
        b.random = a;
        c.random = b;

        J06_RandomPointer sol = new J06_RandomPointer();
        Node copy = sol.copyRandomList(a);

        System.out.println("Original list:");
        printList(a);
        System.out.println("\nCopied list:");
        printList(copy);
    }

    // Helper function for testing
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randVal = (temp.random != null) ? temp.random.val : -1;
            System.out.print("[" + temp.val + ", rand=" + randVal + "] : ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
