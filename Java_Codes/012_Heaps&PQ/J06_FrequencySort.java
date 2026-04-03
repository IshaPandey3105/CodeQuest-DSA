import java.util.*;

class Pair implements Comparable<Pair>{
    int elem;
    int freq;

    Pair(int elem,int freq){
        this.elem = elem;
        this.freq = freq;
    }

    public int compareTo(Pair p){
        if(this.freq == p.freq){
            return p.elem - this.elem; // larger element first
        }
        return this.freq - p.freq; // smaller frequency first
    }
}

public class J06_FrequencySort {

    public static int[] frequencySort(int[] nums) {

        int[] ans = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        // Step 1: Frequency map
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add to heap
        for(int key : map.keySet()){
            minHeap.add(new Pair(key, map.get(key)));
        }

        // Step 3: Build answer
        int i = 0;
        while(!minHeap.isEmpty()){
            Pair p = minHeap.remove();

            for(int j = 0; j < p.freq; j++){
                ans[i++] = p.elem;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,2,3};

        int[] res = frequencySort(nums);
        System.out.println(Arrays.toString(res));
    }
}