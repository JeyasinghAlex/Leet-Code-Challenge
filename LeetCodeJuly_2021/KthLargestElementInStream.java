import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {

    private Queue<Integer> qu;
    private int len;
    public KthLargestElementInStream(int k, int[] nums) {
        this.qu = new PriorityQueue<>();
        this.len = k;
        for (int n : nums) {
            qu.offer(n);
            if (qu.size() > k) {
                qu.poll();
            }
        }
    }

    public int add(int val) {
        qu.offer(val);
        if (qu.size() > len) {
            qu.poll();
        }
        return qu.peek();
    }
}
