import java.util.*;

public class J02_HashMap {

    public static void main(String[] args) {

        // -------- Create HashMap --------
        HashMap<String, Integer> map = new HashMap<>();

        // -------- Insert / Put --------
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);

        // duplicate key → value updated
        map.put("Apple", 15);

        System.out.println("Map: " + map);

        // -------- Get --------
        System.out.println("Get Apple: " + map.get("Apple"));

        // getOrDefault
        System.out.println("Get Orange or default: "+ map.getOrDefault("Orange", 0));

        // -------- Contains --------
        System.out.println("Contains key Mango? "+ map.containsKey("Mango"));
        System.out.println("Contains value 20? "+ map.containsValue(20));

        // -------- Remove --------
        map.remove("Banana");
        System.out.println("After remove Banana: " + map);

        // -------- Size / Empty --------
        System.out.println("Size: " + map.size());
        System.out.println("Is Empty? " + map.isEmpty());

        // -------- Replace --------
        map.replace("Mango", 99);
        System.out.println("After replace Mango: " + map);

        // -------- Iteration Methods --------

        // 1 Iterate using keySet
        System.out.println("\nIterate using keySet:");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // 2 Iterate using entrySet (preferred)
        System.out.println("\nIterate using entrySet:");
        for (Object pair : map.entrySet()) {
            System.out.println(pair);
        }

        // 3 Iterate values only
        System.out.println("\nValues only:");
        for (int v : map.values()) {
            System.out.println(v);
        }

        // 4 forEach (Java 8+)
        System.out.println("\nforEach method:");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        // -------- Convert to arrays --------
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();

        System.out.println("\nKeys array: " + Arrays.toString(keys));
        System.out.println("Values array: " + Arrays.toString(values));
    }
}

