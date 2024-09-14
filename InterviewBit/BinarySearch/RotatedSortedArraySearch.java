package InterviewBit.BinarySearch;

import java.util.List;

public class RotatedSortedArraySearch {

    public int search(final List<Integer> A, int B) {

        int n = A.size();
        int index = searchMinimun(A);
        int a = lowerBond(A, B, 0, index);
        int b = lowerBond(A, B, index, n);

        if (a == n)
            return -1;

        if (A.get(a) == B)
            return a;

        if (b == n)
            return -1;

        if (A.get(b) == B)
            return b;


        return -1;

    }


    private int lowerBond(List<Integer> list, int target, int lo, int hi) {

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > list.get(mid)) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }

        return lo;
    }

    private int searchMinimun(List<Integer> list) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (list.get(mid) > list.get(hi)) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}
