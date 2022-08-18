import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] freq = new int[100001];

        for (int value : map.values()) {
            freq[value]++;
        }

        int sum = 0;
        int count = 0;
        for (int i = freq.length - 1; i >= 0; --i) {

            int n = freq[i];

            while (n-- > 0) {
                sum += i;
                ++count;

                if (sum >= arr.length / 2) {
                    return count;
                }
            }
        }
        return count;
    }

    public int minSetSize_1(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int value : map.values()) {
            qu.offer(value);
        }

        int sum = 0;
        int count = 0;
        while (!qu.isEmpty()) {
            sum += qu.poll();
            ++count;
            if (sum >= arr.length / 2) {
                return count;
            }
        }
        return count;
    }
}
