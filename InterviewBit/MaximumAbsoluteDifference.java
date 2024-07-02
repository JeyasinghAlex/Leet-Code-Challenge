package InterviewBit;

public class MaximumAbsoluteDifference {

    /**
     * case:1 = A[i] > A[j] , i > j => f(i, j) = (A[i] - A[j]) + (i-j) = (A[i]+i) - (A[j]+j)
     * case:2 = A[i] < A[j] , i < j => f(i, j) = -(A[i] - A[j]) + -(i-j) = -(A[i]+i) + (A[j]+j) = - ( (A[i]+i) - (A[j]+j) )
     * case:3 = A[i] > A[j] , i < j => f(i, j) = (A[i] - A[j]) + -(i-j) = (A[i]-i) - (A[j]-j)
     * case:4 = A[i] < A[j] , i > j => f(i, j) = -(A[i] - A[j]) + (i-j) = -(A[i]-i) + (A[j]-j) = - ( (A[i]-i) - (A[j]-j) )
     *
     */
    public int maxArr(int[] A) {

        int n = A.length;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {

            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);

            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }

        int ans1 = max1 - min1;
        int ans2 = max2 - min2;

        return Math.max(ans1, ans2);
    }
}
