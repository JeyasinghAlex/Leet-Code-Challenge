import java.util.ArrayList;
import java.util.List;

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



}
