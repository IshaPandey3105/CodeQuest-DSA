import java.util.HashSet;

public class J01_HashSets {

    public static void main(String[] args) {

        // Create HashSet
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        set1.add(10);
        set1.add(20);
        set1.remove(1000); // no error
        System.out.println(set1.contains(20));
        System.out.println(set1.size());
        Object[] arr = set1.toArray(); // set to array
        System.out.println(arr.length);
        System.out.println("HashSet: " + set1);
        // iterating 
        for(int x : set1){
            System.out.print(x);
        }

        // -------- Basic Operations --------
        // add
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // duplicate (ignored)

        System.out.println("HashSet: " + set);

        // contains
        System.out.println("Contains Mango? " + set.contains("Mango"));

        // remove
        set.remove("Banana");
        System.out.println("After remove Banana: " + set);

        // size
        System.out.println("Size: " + set.size());


        // -------- toArray Operations --------

        // Method 1: Object array
        Object[] arr1 = set.toArray();
        System.out.println("\nObject array:");
        for (Object x : arr1) {  // printing 
            System.out.println(x);
        }

        // Method 2: Typed array (preferred)
        String[] arr2 = set.toArray(new String[0]);
        System.out.println("\nTyped String array:");
        for (String x : arr2) {
            System.out.println(x);
        }
    }
}
