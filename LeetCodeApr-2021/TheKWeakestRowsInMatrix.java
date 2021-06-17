import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TheKWeakestRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {

        int row = mat.length;
        List<int[]> list = new ArrayList<>();
        int[] ans = new int[k];

        for (int i = 0; i < row; ++i) {
            int count = 0;
            for (int j : mat[i]) {
                count +=  j == 1 ? 1 : 0;
            }
            list.add(new int[]{i, count});
        }

        list.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < k; ++i) {
            ans[i] = list.get(i)[0];
        }
        return ans;
    }

    public int[] kWeakestRows_1(int[][] mat, int k) {

        PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int count = 0;
        for (int i = 0; i < mat.length; ++i) {
            count = numOfOnce(mat[i]);
            qu.offer(new int[]{i, count});
        }
        int[] ans = new int[k];
        int index = 0;
        while (!qu.isEmpty() && index < k) {
            ans[index++] = qu.poll()[0];
        }
        return ans;
    }

    private int numOfOnce(int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (arr[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
