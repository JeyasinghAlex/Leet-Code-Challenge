package InterviewBit;

public class MaximumConsecutiveGap {

    public int maximumGap(final int[] A) {

        int n = A.length;
        if (n < 2)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; ++i) {
            max = Math.max(max, A[i] - A[i - 1]);
        }
        return max;
    }
}
