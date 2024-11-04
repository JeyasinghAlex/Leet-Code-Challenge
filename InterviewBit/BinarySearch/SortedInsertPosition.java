package InterviewBit.BinarySearch;

import java.util.List;

public class SortedInsertPosition {

    public int searchInsert(List<Integer> a, int b) {
        int lo = 0;
        int hi = a.size();
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (b > a.get(mid)) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}
