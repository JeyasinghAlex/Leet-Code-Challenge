import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    class QuickSelectAlgorithm {

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println(new KthLargestElementInAnArray().findKthLargest(arr, k));
    }
    public int findKthLargest(int[] nums, int k) {

        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - k;
        while (start < end) {
            int point = partition(nums, start, end);
            if (index > point) {
                start = point + 1;
            } else if (index < point) {
                end = point - 1;
            } else {
                return nums[point];
            }
        }
        return nums[start];
    }

    private int partition(int[] nums, int lo, int hi) {

        int pivot = nums[lo];
        int start = lo;
        int end = hi;
        while (start < end) {

            while (start <= hi && nums[start] <= pivot) {
                ++start;
            }
            while (end >= lo && nums[end] > pivot) {
                --end;
            }

            if (start < end) {
                swap(nums, start, end);
            }
        }
        swap(nums, lo, end);
        return end;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    public int findKthLargest_1(int[] nums, int k) {

        Queue<Integer> qu = new PriorityQueue<>();
        for (int n : nums) {
            qu.offer(n);
            if (qu.size() > k) {
                qu.poll();
            }
        }
        return qu.peek();
    }
}
