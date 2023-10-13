package DynamicProgramming;

public class maximumSumIncreasingSubSequence {

    public int maxSumIS(int[] arr) {

        //code here.

        int n = arr.length;
        int[] msis = new int[n];
        for (int i = 0; i < n; ++i)
            msis[i] = arr[i];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j] && msis[i] < arr[i] + msis[j])
                    msis[i] = arr[i] + msis[j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i)
            max = Math.max(max, msis[i]);

        return max;
    }
}
