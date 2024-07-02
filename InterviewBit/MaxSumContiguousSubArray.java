package InterviewBit;

public class MaxSumContiguousSubArray {

    public int maxSubArray(final int[] A) {

        int n = A.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            sum += A[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
