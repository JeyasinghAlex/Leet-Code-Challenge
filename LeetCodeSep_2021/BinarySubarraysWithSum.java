import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        if (goal < 0) {
            return count;
        }

        while (j < nums.length) {
            sum += nums[j];
            while (sum > goal) {
                sum -= nums[i];
                ++i;
            }
            count += j - i + 1;
            ++j;
        }
        return count;
    }

    public int numSubarraysWithSum_1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int n : nums){
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
