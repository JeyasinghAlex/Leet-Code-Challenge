import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (t == 0 && nums.length == set.size()) return false;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j <= i + k; ++j) {
                if (j >= nums.length) break;
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
