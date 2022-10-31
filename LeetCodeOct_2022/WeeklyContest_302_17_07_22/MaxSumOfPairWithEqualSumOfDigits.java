package WeeklyContest_302_17_07_22;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumOfDigits {

    public int maximumSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int sum = sumDigits(num);
            if (map.containsKey(sum)) {
                ans = Math.max(ans, map.get(sum) + num);
                num = Math.max(map.get(sum), num);
            }
            map.put(sum, num);
        }
        return ans;
    }

    private int sumDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
