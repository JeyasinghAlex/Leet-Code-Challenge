package InterviewBit.BinarySearch;

public class CountElementOccurence {

    public int findCount(final int[] A, int B) {

        int n = A.length;
        int start = lowerBond(A, B);
        int end = upperBond(A, B);

        if (start == n && A[start - 1] != B)
            return 0;

        return end - start;

    }

    private int upperBond(int[] arr, int target) {

        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int lowerBond(int[] arr, int target) {

        int lo = 0;
        int hi = arr.length;

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
}
