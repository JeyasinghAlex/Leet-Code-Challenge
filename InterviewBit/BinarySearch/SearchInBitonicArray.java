package InterviewBit.BinarySearch;

public class SearchInBitonicArray {

    public int solve(int[] A, int B) {
        int point = findBitonicPoint(A);
        int left = lowerBond(A, B, point);
        if (A[left] == B)
            return left;

        int right = reverseLowerBond(A, B, point);
        if (right == A.length)
            return -1;

        if (A[right] == B)
            return right;

        return -1;

    }

    private int reverseLowerBond(int[] arr, int target, int lo) {

        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target < arr[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }

    private int lowerBond(int[] arr, int target, int hi) {

        int lo = 0;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > arr[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }

    private int findBitonicPoint(int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}
