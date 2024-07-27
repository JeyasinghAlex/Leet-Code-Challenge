package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonals {

    public int[][] diagonal(int[][] A) {

        int n = A.length;

        int row = 0;
        int col = 0;
        int idx = 0;
        int[][] ans = new int[n + n - 1][n + n - 1];
        List<Integer> list = null;

        while (col < n) {
            list = new ArrayList<>();
            int i = 0;
            int j = col;
            while (j >= 0) {
                list.add(A[i][j]);
                ++i;
                --j;
            }
            ++col;

            int[] temp = new int[list.size()];
            for (int k = 0; k < list.size(); ++k)
                temp[k] = list.get(k);

            ans[idx++] = temp;
        }

        ++row;
        col = 1;
        while (row < n) {
            list = new ArrayList<>();
            int i = row;
            int j = n - 1;
            while (i < n) {
                list.add(A[i][j]);
                ++i;
                --j;
            }
            ++row;

            int[] temp = new int[list.size()];
            for (int k = 0; k < list.size(); ++k)
                temp[k] = list.get(k);

            ans[idx++] = temp;
        }

        return ans;
    }
}
