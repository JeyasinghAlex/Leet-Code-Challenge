package InterviewBit;

import java.util.*;

public class DisjointIntervals {

    public int solve(int[][] A) {
        int n = A.length;
        Arrays.sort(A, (a, b) -> a[1] - b[1]);
        int cnt = 1;
        int[] temp = A[0];

        for (int i = 1; i < n; ++i) {

            if (A[i][0] > temp[1]) {
                ++cnt;
                temp = A[i];
            }
        }
        return cnt;
    }
}
