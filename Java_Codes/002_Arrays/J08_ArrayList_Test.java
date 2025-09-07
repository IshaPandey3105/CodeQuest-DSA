import java.util.ArrayList;
import java.util.List;

public class J08_ArrayList_Test {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(10); a.add(20); a.add(30);

        List<Integer> b = new ArrayList<>();
        b.add(40); b.add(50);

        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        d.add(60);

        List<List<Integer>> l = new ArrayList<>();
        l.add(a); l.add(b); l.add(c); l.add(d);

        System.out.println(l);

        // Nested loop with get()
        for (int i = 0; i < l.size(); i++) {   // outer list
            List<Integer> inner = l.get(i);   // get each inner list
            for (int j = 0; j < inner.size(); j++) {  // inner list
                System.out.print(inner.get(j) + " ");
            }
            System.out.println();
        }
    }
} 
