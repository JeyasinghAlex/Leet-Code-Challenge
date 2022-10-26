import java.util.HashSet;
import java.util.Set;

public class ContinuousSubArraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int prevSum = 0;
        int currSum = 0;

        for (int i = 0; i < n; ++i) {
            currSum += nums[i];
            currSum %= k;
            if (set.contains(currSum)) {
                return true;
            }
            set.add(prevSum);
            prevSum = currSum;
        }
        return false;
    }
}
