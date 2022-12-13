package WeeklyContest_323_11_12_22;

import java.util.Arrays;

public class LongestSquareStreakInAnArray {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int[] a = uniq(nums);
        int n = a.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0;i < n;i++){
            int q = (int)Math.sqrt(a[i]);
            dp[i] = 1;
            if(q*q == a[i]){
                int ind = Arrays.binarySearch(a, q);
                if(ind >= 0){
                    dp[i] = dp[ind]+1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans == 1 ? -1 : ans;
    }

    public static int[] uniq(int[] a)
    {
        if(a.length == 0)return a;
        int p = 1;
        for(int i = 1;i < a.length;i++) {
            if(a[i] != a[i-1])a[p++] = a[i];
        }
        return Arrays.copyOf(a, p);
    }
}
