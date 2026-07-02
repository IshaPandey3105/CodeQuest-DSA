import java.util.Arrays;

class Item implements Comparable<Item> {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Item other) {

        double ratio1 = (double) this.value / this.weight;
        double ratio2 = (double) other.value / other.weight;

        // Descending order
        return Double.compare(ratio2, ratio1);
    }
}
public class J01_FractionalKnapsack {

    public static double fractionalKnapsack(int W, Item[] arr, int n) {

        // // Sort items based on value/weight ratio in descending order
        // Arrays.sort(arr, (a, b) -> Double.compare(
        //         (double) b.value / b.weight,
        //         (double) a.value / a.weight));

        Arrays.sort(arr);
        
        double maxValue = 0.0;

        for (Item item : arr) {

            // Take the whole item if it fits
            if (item.weight <= W) {
                maxValue += item.value;
                W -= item.weight;
            }
            // Take only the required fraction
            else {
                maxValue += ((double) item.value / item.weight) * W;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        int n = values.length;

        // Create Item array
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        double maxValue = fractionalKnapsack(capacity, items, n);

        System.out.println("Maximum value in Fractional Knapsack: " + maxValue);
    }
}