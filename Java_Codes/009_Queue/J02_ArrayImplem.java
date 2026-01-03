public class J02_ArrayImplem {
    public static class que{    //(r-rear for addition , f-front for removal)
        int r=-1;
        int f=-1;
        int n=5;
        int[] arr = new int[n];
        int size=0;
        void add(int val){
            if(size==0){
                arr[r+1] = val;
                f++;r++;
            }else if(size<n){
                arr[r+1] = val;
                r++;
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
            int store = arr[f];
            f++;
            size--;
            return store;
        }

        boolean isEmpty(){
            if(f==r) return true;
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
            for(int i=f ; i<=r ; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static void main(String[] args) {
        que q = new que();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        q.print();
    }
}
