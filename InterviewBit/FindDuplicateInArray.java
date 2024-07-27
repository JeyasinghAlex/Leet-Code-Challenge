package InterviewBit;

public class FindDuplicateInArray {

    public int repeatedNumber(final int[] A) {

        int n = A.length;
        for (int i = 0; i < n; ++i) {
            int idx = Math.abs(A[i]) - 1;
            if (A[idx] < 0)
                return idx + 1;

            A[idx] = -A[idx];
        }
        return -1;
    }
}
