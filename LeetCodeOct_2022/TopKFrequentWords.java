import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>((a, b) ->
                map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));

        for (String word : map.keySet()) {
            pq.offer(word);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
