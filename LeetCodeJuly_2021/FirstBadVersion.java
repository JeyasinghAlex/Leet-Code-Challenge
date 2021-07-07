public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int lo = 1;
        int hi = n;

        while(lo < hi) {

            int mid = lo + hi >>> 1;
            boolean isBad = isBadVersion(mid);
            if (!isBad) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
