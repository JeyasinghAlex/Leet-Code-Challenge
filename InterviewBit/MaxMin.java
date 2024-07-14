package InterviewBit;

public class MaxMin {

    public int solve(int[] A) {

        int[] ans = helper(A, 0, A.length - 1);
        return ans[0] + ans[1];
    }

    private int[] helper(int[] arr, int i, int j) {

        if (i >= j) {
            return new int[]{arr[i], arr[i]};
        }

        int mid = i + j >>> 1;
        int[] left = helper(arr, i, mid);
        int[] right = helper(arr, mid + 1, j);
        int max = Math.max(left[0], right[0]);
        int min = Math.min(left[1], right[1]);
        return new int[]{max, min};
    }

    public int solve_1(int[] A) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int n = A.length;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return max + min;
    }
}
