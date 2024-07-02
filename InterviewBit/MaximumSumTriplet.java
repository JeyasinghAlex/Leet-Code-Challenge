package InterviewBit;

import java.util.TreeSet;

public class MaximumSumTriplet {

    public int solve(int[] A) {

        int n = A.length;
        int max = 0;
        int[] maxSuffArray = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        maxSuffArray[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxSuffArray[i] = Math.max(maxSuffArray[i + 1], A[i]);
        }

        set.add(Integer.MIN_VALUE);
        for (int i = 0; i < n - 1; ++i) {

            int left = set.lower(A[i]);
            int right = maxSuffArray[i + 1];

            if (left != Integer.MIN_VALUE && left < A[i] && A[i] < right)
                max = Math.max(max, left + A[i] + right);

            set.add(A[i]);
        }
        return max;
    }

    public int solve_1(int[] A) {

        int n = A.length;
        int ans = 0;

        for (int i = 1; i < n; ++i) {

            int left = 0;
            int right = 0;

            for (int j = 0; j < i; ++j) {
                if (A[j] < A[i])
                    left = Math.max(left, A[j]);
            }

            for (int k = i + 1; k < n; ++k) {
                if (A[k] > A[i])
                    right = Math.max(right, A[k]);
            }

            if (left > 0 && right > 0)
                ans = Math.max(ans, left + A[i] + right);
        }
        return ans;
    }
}
