package WeeklyContest_304_31_07_22;

import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        if (set.contains(0))
            set.remove(0);

        return set.size();
    }
}
