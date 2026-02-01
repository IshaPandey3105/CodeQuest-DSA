import java.util.*;

public class J03_TreeSet {

    public static void main(String[] args) {

        // -------- Create TreeSet --------
        TreeSet<Integer> set = new TreeSet<>();

        // -------- Add elements --------
        set.add(50);
        set.add(20);
        set.add(70);
        set.add(10);
        set.add(50); // duplicate ignored

        System.out.println("TreeSet: " + set);  // sorted order

        // -------- Basic Operations --------
        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Remove 70: " + set.remove(70));
        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());

        // -------- First and Last --------
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // -------- Ceiling / Floor --------
        System.out.println("Ceiling of 25: " + set.ceiling(25)); // >= 25
        System.out.println("Floor of 25: " + set.floor(25));     // <= 25

        // -------- Iteration Methods --------

        // 1 Using enhanced for loop
        System.out.println("\nIteration using for-each:");
        for (int val : set) {
            System.out.println(val);
        }

        // 2 Using iterator
        System.out.println("\nIteration using iterator:");
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // -------- Convert to Array --------
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println("\nArray from TreeSet: " + Arrays.toString(arr));

        // -------- Subset / HeadSet / TailSet --------
        System.out.println("HeadSet (<20): " + set.headSet(20));
        System.out.println("TailSet (>=20): " + set.tailSet(20));
        System.out.println("SubSet (20 to 50): " + set.subSet(20, 50));
    }
}
