package InterviewBit;

import java.util.Arrays;

public class NobleInteger {

    public int solve(int[] A) {

        int n = A.length;
        Arrays.sort(A);

        int i = 0;
        while (i < n) {
            int j = i;
            while (i < n && A[i] == A[j]) {
                ++i;
            }

            if (A[j] == n - i)
                return 1;
        }
        return -1;
    }
}
