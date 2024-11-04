package InterviewBit.BinarySearch;

public class CapacityToShipPackagesWithinBDays {

    public int solve(int[] A, int B) {

        int n = A.length;
        int sum = 0;
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < n; ++i) {
            lo = Math.max(lo, A[i]);
            hi += A[i];
        }

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (canShip(A, mid, B)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] arr, int capacity, int days) {

        int cnt = 1;
        int sumOfWeight = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (sumOfWeight + arr[i] > capacity) {
                ++cnt;
                if (cnt > days) {
                    return false;
                }
                sumOfWeight = arr[i];
            }
            else {
                sumOfWeight += arr[i];
            }
        }
        return true;
    }
}
