package InterviewBit;

public class SortArrayWithSquares {

    public int[] solve(int[] A) {

        int n = A.length;
        int[] ans = new int[n];

        int i = 0;
        int j = n - 1;
        int idx = n - 1;

        while (i <= j) {
            int a = A[i] * A[i];
            int b = A[j] * A[j];

            ans[idx--] = Math.max(a, b);
            if (a > b)
                ++i;
            else
                --j;
        }
        return ans;
    }
}
