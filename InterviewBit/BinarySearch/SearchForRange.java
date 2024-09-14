package InterviewBit.BinarySearch;

public class SearchForRange {

    public int[] searchRange(final int[] A, int B) {

        int n = A.length;
        int start = lowerBond(A, B);
        if (start == n || A[start] != B)
            return new int[]{-1, -1};

        int end = upperBond(A, B);
        return new int[]{start, end - 1};
    }

    private int lowerBond(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBond(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
