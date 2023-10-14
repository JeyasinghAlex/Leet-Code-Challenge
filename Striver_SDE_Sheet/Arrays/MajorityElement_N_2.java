package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_N_2 {

    public int majorityElement(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (int key : map.keySet()) {
            if (map.get(key) > n / 2)
                return key;
        }
        return -1;
    }

    public int majorityElement_1(int[] nums) {

        int n = nums.length;
        int cnt = 0;
        int majority = 0;

        for (int i = 0; i < n; ++i) {
            if (cnt == 0) {
                cnt = 1;
                majority = nums[i];
            }
            else if (majority == nums[i]) {
                ++cnt;
            }
            else {
                --cnt;
            }
        }

        cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (majority == nums[i])
                ++cnt;
        }
        return cnt > n / 2 ? majority : -1;
    }
}
