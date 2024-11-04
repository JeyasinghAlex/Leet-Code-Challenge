package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        List<Integer> list = new ArrayList<>();
        int m = a.size();
        int n = b.size();

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) {
                list.add(a.get(i));
                ++i;
            }
            else {
                list.add(b.get(j));
                ++j;
            }
        }

        while (i < m)
            list.add(a.get(i++));

        while (j < n)
            list.add(b.get(j++));

        int size = m + n;
        int mid = size / 2;
        if (size % 2 == 1)
            return (double) list.get(mid);

        return (double) (list.get(mid) + list.get(mid - 1)) / 2.0;
    }
}
