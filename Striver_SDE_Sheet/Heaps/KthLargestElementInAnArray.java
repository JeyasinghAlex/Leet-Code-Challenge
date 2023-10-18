package Heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        Queue<Integer> qu = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            qu.offer(nums[i]);

            if (qu.size() > k)
                qu.poll();
        }
        return qu.peek();
    }
}
