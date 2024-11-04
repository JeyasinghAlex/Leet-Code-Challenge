package InterviewBit.BinarySearch;

public class SquareRootOfInteger {

    public int sqrt(int A) {

        if (A == 0 || A == 1)
            return A;

        int lo = 1;
        int hi = A;
        int result = 0;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            long midSqrt = (long) mid * mid;
            if (midSqrt == A) {
                return mid;
            }
            else if (midSqrt < A) {
                lo = mid + 1;
                result = mid;
            }
            else {
                hi = mid - 1;
            }
        }
        return result;
    }
}
