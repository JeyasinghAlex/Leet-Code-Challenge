package InterviewBit.BinarySearch;

import java.util.ArrayList;

public class SmallerOrEqualElements {

    public int solve(ArrayList<Integer> A, int B) {

        // UpperBond
        int n = A.size();
        int lo = 0;
        int hi = A.size();

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (B < A.get(mid)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
