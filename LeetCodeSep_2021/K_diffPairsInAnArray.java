import java.util.Arrays;

public class K_diffPairsInAnArray {

    public int findPairs(int[] nums, int k) {

        if (k < 0 || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length) {
                int diff = nums[j] - nums[i];
                if (diff == k) {
                    ++count;
                    break;
                }
                if (diff > k) {
                    break;
                }
                ++j;
            }
        }
        return count;
    }
}
