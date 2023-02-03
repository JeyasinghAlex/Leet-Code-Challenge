package BiWeeklyContest_96_21_01_23;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSubSequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        long sum = 0;
        long ans = Integer.MIN_VALUE;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = n - 1; i >= 0; --i) {
            pq.offer(arr[i][0]);
            sum += arr[i][0];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.max(ans, sum * arr[i][1]);
            }
        }
        return ans;
    }
}
