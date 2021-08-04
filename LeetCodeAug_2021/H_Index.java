import java.util.Arrays;

public class H_Index {

    public int hIndex(int[] citations) {

        int n = citations.length;
        Arrays.sort(citations);
        int lo = 0;
        int hi = citations.length;
        int max = 0;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (citations[mid] >= n - mid) {
                max = n - mid;
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return max;
    }

    public int hIndex_1(int[] citations) {

        int n = citations.length;
        Arrays.sort(citations);
        int i = 0;
        for (i = 1; i <= n; ++i) {

            if (citations[n - i] < i) {
                break;
            }
        }
        return i - 1;
    }
}
