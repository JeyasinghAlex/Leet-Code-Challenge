package InterviewBit;

public class MoveZeroes {

    public int[] solve(int[] A) {

        int n = A.length;
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            if (A[i] != 0) {
                A[idx++] = A[i];
            }
        }

        while (idx < n) {
            A[idx++] = 0;
        }
        return A;
    }
}
