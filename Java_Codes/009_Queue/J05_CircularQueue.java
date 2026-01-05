public class J05_CircularQueue {
    public static class Que{    //(r-rear for addition , f-front for removal)
        int r=-1;               //if rear reaches end but array is not full then change rear
        int f=-1;
        int n=5;
        int[] arr = new int[n];
        int size=0;

        void add(int val){
            if(size==0){
                arr[++r] = val;
                f++;
            }else if(size<n){
                if(r==n-1){
                    r=0;
                    arr[r]=val;
                }else{
                    arr[++r] = val;
                }
            }else{
                System.out.println("OverFlow");
            }
            size++;
        }

        int remove(){
            if(size==0){ 
                System.out.println("UnderFlow");
                return -1;
            }
            else{   
                int store = arr[f];
                if(f==n-1) f=0;   // i forgot this case
                else f++;
                size--;
                return store;
            }
        }

        boolean isEmpty(){
            if(size==0) return true;
            else return false;
        }

        int peek(){
            if(!isEmpty()){
                return arr[f];
            }
            return -1;
        }

        void print(){
            if(size==0){ System.out.println("UnderFlow");}
            else if(r<=f){
                for(int i=f ; i<n ; i++){
                    System.out.print(arr[i] + " ");
                }
                for(int i=0 ; i<=r ; i++){
                    System.out.print(arr[i] + " ");
                }
            }else{
                for(int i=f ; i<=r ; i++){
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Que q = new Que();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        q.add(30);
        q.add(40);
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        q.add(10);
        q.print();
    }
}
