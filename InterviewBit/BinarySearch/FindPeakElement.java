package InterviewBit.BinarySearch;

public class FindPeakElement {

    public int solve(int[] A) {

        int n = A.length;
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return A[lo];
    }
}
