package InterviewBit;

import java.util.*;
public class AssignMiceToHoles {

    public int mice(int[] A, int[] B) {

        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, Math.abs(A[i] - B[i]));
        }
        return max;
    }
}
