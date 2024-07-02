package InterviewBit;

public class MinimumLightsToActivate {

    public int solve(int[] A, int B) {

        int n = A.length;
        int i = 0;
        int cnt = 0;

        while (i < n) {
            int left = Math.max(0, i - B + 1);
            int right = Math.min(n - 1, i + B - 1);
            boolean isFound = false;
            while (right > left) {
                if (A[right] == 1) {
                    isFound = true;
                    break;
                }
                --right;
            }

            if (!isFound)
                return -1;

            ++cnt;
            i = right + B;
        }
        return cnt;
    }
}
