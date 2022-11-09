package BiWeeklyContest_80_11_06_22;

public class CountSubArraysWithScoreLessThan_K {

    public long countSubarrays(int[] nums, long k) {

        long ans = 0;
        int n = nums.length;
        int right = 0;
        int left = 0;
        long sum = 0;
        int l = 0;

        while (right < n ) {
            sum += nums[right];
            ++l;
            while (left <= right && (sum * l) >= k) {
                sum -= nums[left++];
                --l;
            }
            ans += right - left + 1;
            ++right;
        }
        return ans;
    }
}
