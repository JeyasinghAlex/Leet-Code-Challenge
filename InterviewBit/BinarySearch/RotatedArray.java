package InterviewBit.BinarySearch;

import java.util.List;

public class RotatedArray {

    public int findMin(final List<Integer> a) {

        int lo = 0;
        int hi = a.size() - 1;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (a.get(mid) > a.get(hi)) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return a.get(lo);
    }
}
