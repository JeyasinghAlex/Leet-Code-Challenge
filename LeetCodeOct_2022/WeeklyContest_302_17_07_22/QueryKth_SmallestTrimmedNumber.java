package WeeklyContest_302_17_07_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueryKth_SmallestTrimmedNumber {

    class Pair {
        int index;
        String num;

        public Pair(String num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        int n = nums.length;
        int len = nums[0].length();
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.num.equals(b.num) ? a.index - b.index : a.num.compareTo(b.num));
        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {

            int k = query[0];
            int trim = query[1];
            for (int i = 0; i < n; ++i) {
                String num = nums[i];
                String trimStr = num.substring(len - trim, len);
                pq.offer(new Pair(trimStr, i));
            }
            while (k-- > 1) {
                pq.poll();
            }
            ans[idx++] = pq.peek().index;
            pq.clear();
        }
        return ans;
    }
}
