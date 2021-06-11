public class SubArrayProductLessThanK {

    public int numSubArrayProductLessThanK(int[] nums, int k) {

        int mul = 1;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length) {
            mul *= nums[right];
            while (left <= right && mul >= k) {
                mul = mul / nums[left++];
            }
            count += right - left + 1;
            right++;
        }

        return count;
    }
}
