import java.util.Arrays;

public class AlphabeticalString {

    public int lengthOfLIS(String s) {

        int[] dp = new int[26];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (char ch : s.toCharArray()) {
            int temp = lowerBond(dp, ch - 'a');
            dp[temp] = ch - 'a';
        }
        return 26 - lowerBond(dp, Integer.MAX_VALUE);
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
}
