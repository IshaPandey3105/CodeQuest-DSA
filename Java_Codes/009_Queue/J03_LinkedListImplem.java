public class J03_LinkedListImplem {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static class ll{
        int size=0;
        Node head=null;
        Node tail=null;

        void add(int x ){
            Node temp = new Node(x);
            if(size==0){
                head=tail=temp;
            }else{
                tail.next=temp;
                tail=temp;
            }
            size++;
        }

        int remove(){
            if(head==null) return -1;
            int x=head.val;
            head=head.next;
            size--;
            return x;
        }

        int peek(){
            if(head==null) return -1;
            return head.val;
        }

        boolean isEmpty(){
            if(size==0) return true;
            else return false;
        }

        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val + " ");
                temp=temp.next;
            }
        }
    }

    public static void main(String[] args) {
        ll list = new ll();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.remove());
        System.out.println(list.peek());
        System.out.println(list.isEmpty());
        System.out.println(list.size);
        list.display();
    }
}
