class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
class Stack{
    private Node head=null;
    private int size=0;

    void push(int elem) {
        Node newNode=new Node(elem);
        newNode.next=head;
        head=newNode;
        size++;
    }

    int pop(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }
        int top=head.val;
        head=head.next;
        size--;
        return top;
    }

    int peek(){
        if(head==null) return -1;
        return head.val;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        if(head==null) return true;
        return false;
    }

    void Display(){
        // For reverse order use loop traversing
        // Node temp=head;
        // while(temp!=null){
        //     System.out.print(temp.val +" ");
        //     temp=temp.next;
        // }
        // For same order use recursion
        newDisplay(head);
    }
    void newDisplay(Node head){
        if(head==null) return;
        newDisplay(head.next);
        System.out.print(head.val +" ");
    }
}
public class J04_LLImplem {
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st.pop()); 
        st.Display();   
        System.out.print("\npeek elem : "+st.peek());   
        System.out.println("\n"+st.isEmpty());   
        System.out.println("Size is : "+st.size());   
    }
}
