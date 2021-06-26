import java.util.PriorityQueue;

public class SortIntegersByTheNumberOfOneBits {

    public int[] sortByBits(int[] arr) {

        PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < arr.length; ++i) {
            int bitCount = bitCount(arr[i]);
            qu.offer(new int[]{arr[i], bitCount});
        }

        int idx = 0;
        while (!qu.isEmpty()) {
            arr[idx++] = qu.poll()[0];
        }
        return arr;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}
