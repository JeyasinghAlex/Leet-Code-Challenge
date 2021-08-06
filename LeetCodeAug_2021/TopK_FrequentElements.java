import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK_FrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }

        for (int key : map.keySet()) {
            qu.offer(key);
            if (qu.size() > k) {
                qu.poll();
            }
        }

        int idx = 0;
        while (!qu.isEmpty()) {
            ans[idx++] = qu.poll();
        }
        return ans;
    }
}
