package LeetCodeJun_2021.weekly_6_6_21;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        int count = 0;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] != nums[i - 1]) {
                count++;
            }
            ans += count;
        }
        return ans;
    }
}
