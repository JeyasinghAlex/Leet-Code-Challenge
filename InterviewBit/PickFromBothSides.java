package InterviewBit;

public class PickFromBothSides {

    public int solve(int[] A, int B) {

        int n = A.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < B; ++i) {
            sum += A[i];
        }

        int index = n - 1;
        max = sum;
        for (int i = B - 1; i >= 0; --i) {
            sum += A[index] - A[i];
            max = Math.max(max, sum);
            --index;
        }

        return max;
    }
}
