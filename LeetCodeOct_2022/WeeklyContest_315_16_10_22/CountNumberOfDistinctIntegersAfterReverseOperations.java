package WeeklyContest_315_16_10_22;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfDistinctIntegersAfterReverseOperations {

    public int countDistinctIntegers(int[] nums) {

        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            int reverseNum = reverse(nums[i]);
            set.add(nums[i]);
            set.add(reverseNum);
        }
        return set.size();
    }

    private int reverse(int num) {

        int n = 0;
        while (num > 0) {
            int rem = num % 10;
            n = n * 10 + rem;
            num = num / 10;
        }
        return n;
    }
}
