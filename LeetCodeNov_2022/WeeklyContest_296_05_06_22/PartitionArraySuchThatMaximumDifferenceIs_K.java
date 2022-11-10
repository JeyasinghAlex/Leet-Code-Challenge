package WeeklyContest_296_05_06_22;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIs_K {

    public int partitionArray(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int min = 0;
        int left = 0;
        int right = 0;
        while (right < n) {

            while (right < n && nums[right] - nums[left] <= k) {
                ++right;
            }
            ++ans;
            left = right;
        }
        return ans;
    }
}
