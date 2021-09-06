import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheKthLargestIntegerInTheArray {

    public String kthLargestNumber(String[] nums, int k) {

        Queue<String> qu = new PriorityQueue<>((a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));

        for (String s : nums) {
            qu.offer(s);
            if (qu.size() > k) {
                qu.poll();
            }
        }
        return qu.poll();
    }
}
