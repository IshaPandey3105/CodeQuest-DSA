import java.util.*;

public class J04_TreeMap {

    public static void main(String[] args) {

        // -------- Create TreeMap --------
        TreeMap<String, Integer> map = new TreeMap<>();

        // -------- Insert / Put elements --------
        map.put("Apple", 50);
        map.put("Banana", 20);
        map.put("Mango", 70);
        map.put("Orange", 30);
        map.put("Apple", 60); // duplicate key → value updated

        System.out.println("TreeMap: " + map); // sorted according to keys

        // -------- Basic Operations --------
        System.out.println("Contains key Banana? " + map.containsKey("Banana"));
        System.out.println("Contains value 30? " + map.containsValue(30));
        System.out.println("Get Mango: " + map.get("Mango"));
        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());
        map.remove("Orange");
        System.out.println("After removing Orange: " + map);

        // -------- First and Last Keys/Entries --------
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("First entry: " + map.firstEntry());
        System.out.println("Last entry: " + map.lastEntry());

        // -------- Ceiling / Floor --------
        System.out.println("Ceiling key for 'Blueberry': " + map.ceilingKey("Blueberry"));
        System.out.println("Floor key for 'Blueberry': " + map.floorKey("Blueberry"));

        // -------- Iteration Methods --------

        // 1 Iterate using keySet
        System.out.println("\nIteration using keySet:");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // 2 Iterate using entrySet (preferred)
        System.out.println("\nIteration using entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // -------- Convert to Arrays --------
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();

        System.out.println("\nKeys array: " + Arrays.toString(keys));
        System.out.println("Values array: " + Arrays.toString(values));

        // -------- SubMap / HeadMap / TailMap --------
        System.out.println("HeadMap (<Mango): " + map.headMap("Mango"));
        System.out.println("TailMap (>=Banana): " + map.tailMap("Banana"));
        System.out.println("SubMap (Banana to Mango): " + map.subMap("Banana", "Mango"));
    }
}
