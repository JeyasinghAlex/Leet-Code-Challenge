package InterviewBit;

import java.util.Arrays;

public class MaximumUnsortedSubArray {

    public int[] subUnsort(int[] A) {

        int n = A.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = A[i];
        }

        Arrays.sort(arr);

        int st = -1;
        int ed = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] != arr[i]) {
                st = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            if (A[i] != arr[i]) {
                ed = i;
                break;
            }
        }

        if (st == -1 || ed == -1)
            return new int[]{-1};

        return new int[]{st, ed};
    }
}
