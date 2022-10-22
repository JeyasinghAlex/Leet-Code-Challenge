package WeeklyContest_306_28_8_22;

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScore {

    public int edgeScore(int[] edges) {

        int n = edges.length;

        long[] score = new long[n];

        for (int i = 0; i < n; ++i) {
            score[edges[i]] += i;
        }

        int ans = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            if (score[i] > max) {
                max = score[i];
                ans = i;
            }
        }
        return ans;
    }

    public int edgeScore_1(int[] edges) {

        int n = edges.length;

        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.put(edges[i], map.getOrDefault(edges[i], 0l) + i);
        }

        long max = Long.MIN_VALUE;
        int ans = 0;

        for (int key : map.keySet()) {
            long val = map.get(key);
            if (val >= max) {
                if (max == val) {
                    ans = Math.min(ans, key);
                } else {
                    ans = key;
                }
                max = val;
            }
        }
        return ans;
    }
}
