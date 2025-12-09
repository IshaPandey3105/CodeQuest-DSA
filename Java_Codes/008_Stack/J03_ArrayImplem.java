 class stack{
    private int[] arr=new int[5];
    private int indx=0;

    void push(int elem){
        if(isFull()){
            System.out.println("OverFlow");
            return;
        }
        arr[indx]=elem;
        indx++;
    }

    int peek(){
        if(isFull()){
            System.out.println("OverFlow");
            return -1;
        }
        return arr[indx-1];
    }

    int pop(){
        if(isEmpty()){
            System.out.println("UnderFlow");
            return -1;
        }
        int elem=arr[indx-1];
        arr[indx-1]=0;
        indx--;
        return elem;
    }

    int size(){
        return indx;
    }

    boolean isFull(){
        if(indx==arr.length) return true;
        return false;
    }

    boolean isEmpty(){
        if(indx==0) return true;
        return false;
    }

    void Display(){
        for(int i=0;i<=indx-1;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
public class J03_ArrayImplem {
    public static void main(String[] args) {
        stack st=new stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size());
        st.push(4);
        st.push(5);
        st.Display();
        System.out.println(st.isFull());
        System.out.println(st.isEmpty());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
    }
}
