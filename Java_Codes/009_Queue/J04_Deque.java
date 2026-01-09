// ll ::: (1)->(2)->(3)
//        (1)<-(2)<-(3)
//        Front     Rear

import java.util.ArrayDeque;
import java.util.Deque;

public class J04_Deque {
    static class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data=data;
            this.next=this.prev=null;
        }
    }
    
    public static class deque{
        node front;
        node rear;
        int size;
        deque(){
            front=null;
            rear=null;
            size=0;
        }

        boolean isEmpty(){
            if(size==0) return true;
            else return false;
        }

        void insertFront(int data){
            node temp = new node(data);
            if(front==null){
                front=rear=temp;  // deque is empty
            }else{
                temp.next=front;
                front.prev=temp;
                front=temp;
            }
            size++;
        }

        void insertRear(int data){
            node temp = new node(data);
            if(rear==null){
                front=rear=temp;  // deque is empty
            }else{
                temp.prev=rear;
                rear.next=temp;
                rear=temp;
            }
            size++;
        }
       
        int removeFront(){
            if(isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }
            node temp=front;
            front=front.next;
            if(front==null){
                front=rear=null;
            }else{
                front.prev=null;
            }
            size--;
            return temp.data;
        }

        int removeRear(){
            if(isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }
            node temp=rear;
            rear=rear.prev;
            if(rear==null){
                front=rear=null;  // deque become null
            }else{
                rear.next=null;
            }
            size--;
            return temp.data;
        }

        int getFront(){
            if(front==null) return -1;
            return front.data;
        }

        int getRear(){
            if(rear==null) return -1;
            return rear.data;
        }

        void display(){
            node temp = front;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        deque q = new deque();
        q.insertFront(1);
        q.insertFront(2);
        q.insertRear(100);
        System.out.println(q.removeFront());
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        q.display();
        System.out.println(q.removeFront());
        System.out.println(q.removeRear());
        System.out.println(q.isEmpty());


// -------------Predefined in Java----------------
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(100);
        dq.addFirst(200);
        dq.addFirst(500);
        dq.addLast(900);
        System.out.println(dq);   // [500, 200, 100, 900]
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        System.out.println(dq.isEmpty());
    }
}
