package weekly_24_7_22;

import java.util.HashSet;
import java.util.Set;

public class NumberOfExcellentPairs {

    public long countExcellentPairs(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int[] bitCount = new int[31];
        for (int i = 0; i < nums.length; ++i) {
            if (set.add(nums[i])) {
                int count = bitCount(nums[i]);
                bitCount[count]++;
            }
        }

        long ans = 0L;
        for (int i = 0; i < 31; ++i) {
            for (int j = 0; j < 31; ++j) {
                if (i + j >= k) {
                    ans += (long) bitCount[i] * bitCount[j];
                }
            }
        }
        return ans;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
