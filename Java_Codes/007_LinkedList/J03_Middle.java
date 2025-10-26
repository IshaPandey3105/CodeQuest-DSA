class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
public class J03_Middle {
    static Node head;
    public static void PrintLL(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static int MiddleNode(){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;   // as we want middle or left middle if 2 exist
        }
        return slow.val;
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        // Node e = new Node(50);
        head=a;
        a.next=b;
        b.next=c;
        c.next=d;
        // d.next=e;
        PrintLL();
        System.out.println(MiddleNode());
    }
}
