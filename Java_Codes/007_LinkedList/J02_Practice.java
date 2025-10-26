class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
class SingllyList{
    Node head;
    Node tail;
    int size;
    public void size(){
        System.out.println(size);
    }
    public void Display(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void insertAtStart(int val){
        Node temp = new Node(val);
        if(head==null) head=tail=temp;
        else {
            temp.next = head; 
            head=temp;
        }
        size++;
    }
    public void insertAtEnd(int val){
        Node temp = new Node(val);
        if(head==null) head=tail=temp;
        else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    public void insert(int val,int indx){
        if(indx<0 || indx > size){
            System.out.println("Error");
            return;
        }
        if(indx==0){
            insertAtStart(val);
            return;
        }
        if(indx==size){
            insertAtEnd(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp=head;
        for(int i=0;i<indx-1;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    public void deleteAtStart(){
        if(head==null){
            System.out.println("null");
            return;
        }
        head=head.next;
        size--;
    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("null");
            return;
        }
        Node temp=head;
        while(temp.next.next !=null){
            temp=temp.next;
        }
        tail=temp;
        temp.next=null;
        size--;
    }
    public void delete(int indx){
        if(indx<0 || indx > size){
            System.out.println("Error");
            return;
        }
        if(indx==0){
            deleteAtStart();;
            return;
        }
        if(indx==size){
            deleteAtEnd();;
            return;
        }
        Node temp=head;
        for(int i=0;i<indx-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    public int get(int indx) throws Error{
        if(indx>=size || indx<0) throw new Error("Madam Error!");
        if(indx==size) return tail.val;
        Node temp=head;
        for(int i=0;i<indx;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    public void set(int val,int indx) throws Error{
        if(indx>=size || indx<0) throw new Error("Madam Error!");
        if(indx==size) {tail.val=val; return;}
        Node temp=head;
        for(int i=0;i<indx;i++){
            temp=temp.next;
        }
        temp.val=val;
    }
    public int MiddleNode(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.val;
    }
}
public class J02_Practice {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        SingllyList list = new SingllyList();
        list.size = 4; // since you have 4 nodes: 10,20,30,40
        list.head=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        list.tail=d;
        list.Display();

        list.insertAtStart(0);
        list.Display();
        list.insertAtEnd(50);
        list.Display();
        list.insert(2,2);
        list.Display();
        
        list.deleteAtStart();
        list.Display();
        list.deleteAtEnd();
        list.Display();
        list.delete(2);
        list.Display();

        System.out.println(list.get(3));
        list.set(0, 0);
        list.Display();

        System.out.println(list.MiddleNode());
    }
}
