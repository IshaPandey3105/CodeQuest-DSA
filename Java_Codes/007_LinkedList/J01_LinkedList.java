class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}

public class J01_LinkedList{
    static Node Head = null;
    static int size = 0;

    public static void PrintLL(Node head){
        while(head != null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
     
    public static void AddFirst(int value){
        if(Head==null){
            Head=new Node(value);
            size++;
            return;
        }
        Node newNode=new Node(value);
        newNode.next= Head;
        Head=newNode;
        size++;
    }
    
    public static void AddLast(int value){
        if(Head==null){
            Head=new Node(value);
            size++;
            return;
        }
        Node newNode=new Node(value);
        Node temp=Head;
        
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next=newNode;
        size++;
    }

    public static void Middle(int indx,int value){
        if(size<=indx){
            System.out.println("Can't add at this particular locaton");
            return;
        }
        if(indx==0){AddFirst(value); return;}
        if(indx==size-1){ AddLast(value); return;}

        Node temp=Head;
        while(indx>1){
            temp=temp.next;
            indx--;
        }
        Node newNode=new Node(value);
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }

    public static void DeleteStart(){
        if(Head==null || Head.next==null){
            Head=null;
            size=0;
            return;
        }
        Node Temp = Head;
        Head= Head.next;
        Temp.next=null;
        size--;
        return;
    }
    
    public static void DeleteEnd(){
        if(Head==null || Head.next==null){
            Head=null;
            size=0;
            return;
        }
        Node Temp=Head;
        while(Temp.next.next!=null){
            Temp=Temp.next;
        }
        Temp.next=null;
        size--;
        return;
    }

    public static void DeleteMiddle(int indx){
        if(Head==null || Head.next==null){
            Head=null;
            size=0;
            return;
        }
        if(size<=indx){
            System.out.println("Can't delete at this particular locaton");
            return;
        }
        if(indx==0){DeleteStart(); return;}
        if(indx==size-1){ DeleteEnd(); return;}

        Node temp=Head;
        for (int i = 0; i < indx - 1; i++) {
            temp = temp.next;
        }
        Node temp1=temp.next;
        temp.next=temp1.next;
        temp1.next=null;
        size--;
        return;
    }

    public static void main(String[] args) {


        AddLast(10);
        AddLast(20);
        AddLast(30);
        AddLast(40);
        AddLast(50);

        PrintLL(Head);
        
        AddFirst(60);
        PrintLL(Head);
        
        Middle(2, 100);
        PrintLL(Head);

        DeleteStart();
        PrintLL(Head);

        DeleteEnd();
        PrintLL(Head);
        
        DeleteMiddle(2);
        PrintLL(Head);
        System.out.println(size);
    }
}

