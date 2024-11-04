package InterviewBit.BinarySearch;

public class PaintersPartitionProblem {

    public int paint(int A, int B, int[] C) {

        long sum = 0;
        long max = 0;
        int n = C.length;

        for (int i = 0; i < n; ++i) {
            sum += C[i];
            if (C[i] > max)
                max = C[i];
        }

        long lo = max;
        long hi = sum;
        long ans = Integer.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + hi >>> 1;
            if(isPossible(mid, A, C)) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        ans = (lo * B) % 10000003;
        return (int) ans;
    }

    private boolean isPossible(long bar, long p, int[] arr) {
        long cnt = 0;
        long time = 0;
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > bar)
                return false;

            if (time + arr[i] <= bar)
                time += arr[i];
            else {
                ++cnt;
                time = arr[i];
            }
        }

        if (cnt > p)
            return false;

        return true;
    }
}
