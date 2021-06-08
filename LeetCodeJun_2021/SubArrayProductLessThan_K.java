package LeetCodeJun_2021;

public class SubArrayProductLessThan_K {

    public int numSubArrayProductLessThanK(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int mul = 1;
        int ans = 0;
        while (right < nums.length) {
            mul *= nums[right];

            while (left <= right && mul >= k) {
                mul = mul / nums[left++];
            }

            ans += (right - left + 1);
            right++;
        }
        return ans;
    }
}
