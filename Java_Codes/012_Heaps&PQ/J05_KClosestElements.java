import java.util.*;

class Comp implements Comparable<Comp>{
    int d;
    int n;

    Comp(int d,int n){
        this.d = d;
        this.n = n;
    }

    public int compareTo(Comp c){
        if(this.d == c.d){
            return this.n - c.n; // smaller number first
        }
        return this.d - c.d; // smaller distance first
    }
}

public class J05_KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Comp> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            int d = Math.abs(arr[i] - x);
            maxHeap.add(new Comp(d, arr[i]));

            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        while(!maxHeap.isEmpty()){
            list.add(maxHeap.remove().n);
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;

        System.out.println(findClosestElements(arr, k, x));
    }
}