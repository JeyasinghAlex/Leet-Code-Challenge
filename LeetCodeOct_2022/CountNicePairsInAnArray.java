import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {

    public int countNicePairs(int[] nums) {

        int mod = 1000000007;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int reverse = rev(nums[i]);
            int diff = nums[i] - reverse;
            int cnt = map.getOrDefault(diff, 0);
            ans = (ans + cnt) % mod;
            map.put(diff, cnt + 1);
        }
        return ans;
    }

    private int rev(int num) {

        int n = 0;
        while (num > 0) {
            int rem = num % 10;
            n = (n * 10) + rem;
            num /= 10;
        }
        return n;
    }
}
