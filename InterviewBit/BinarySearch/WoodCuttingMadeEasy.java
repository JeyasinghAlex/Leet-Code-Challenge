package InterviewBit.BinarySearch;

public class WoodCuttingMadeEasy {

    public int solve(int[] A, int B) {

        int n = A.length;
        int max = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            max = Math.max(max, A[i]);
        }

        int lo = 0;
        int hi = max;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            long chops = getNumberOfChop(A, mid);
            if (chops >= B) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return ans;
    }

    private long getNumberOfChop(int[] arr, int size) {
        long sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > size) {
                sum += arr[i] - size;
            }
        }
        return sum;
    }
}
