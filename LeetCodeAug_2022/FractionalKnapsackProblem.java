import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class MySort implements Comparator<Item> {

        public int compare(Item a, Item b) {
            double x = (double) a.value / (double) a.weight;
            double y = (double) b.value / (double) b.weight;

            if (x < y) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n)
    {
        // Your code here

        Arrays.sort(arr, new MySort());

        int total = 0;
        double profit = 0.0;

        for (Item item : arr) {

            total += item.weight;

            if (total <= w) {
                profit += item.value;
            } else {
                total -= item.weight;
                int remain = w - total;
                profit +=  ((double)item.value / (double)item.weight) * (double) remain;
                break;
            }
        }
        return profit;
    }
}
