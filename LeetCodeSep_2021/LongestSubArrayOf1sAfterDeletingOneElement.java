public class LongestSubArrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int ans = 0;
        for (int i = 0, j = 0, sum = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (i < j && sum < j - i)  {
                sum -= nums[i++];
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    public int longestSubarray_2(int[] A) {
        int i = 0, j, k = 1, res = 0;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (A[i] == 0) {
                    k++;
                }
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    public int longestSubarray_1(int[] nums) {

        int prev = 0;
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == 1) {
                ++curr;
            }
            if (i == nums.length - 1  || nums[i] == 0) {
                max = Math.max(max, prev + curr);
                prev = curr;
                curr = 0;
            }
        }
        return max == nums.length ? max - 1 : max;
    }
}
