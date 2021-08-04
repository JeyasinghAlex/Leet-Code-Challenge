import java.util.Arrays;

public class H_Index_II {

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
}
