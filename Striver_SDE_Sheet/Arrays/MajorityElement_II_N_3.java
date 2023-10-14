package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_II_N_3 {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        int min = n / 3;

        for (int key : map.keySet()) {
            if (map.get(key) > min)
                ans.add(key);
        }
        return ans;
    }

    public List<Integer> majorityElement_1(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int cnt1 = 0;
        int cnt2 = 0;
        int majority1 = 0;
        int majority2 = 0;

        for (int i = 0; i < n; ++i) {
            if (cnt1 == 0 && majority2 != nums[i]) {
                cnt1 = 1;
                majority1 = nums[i];
            }
            else if (cnt2 == 0 && majority1 != nums[i]) {
                cnt2 = 1;
                majority2 = nums[i];
            }
            else if (majority1 == nums[i]) {
                ++cnt1;
            }
            else if (majority2 == nums[i]) {
                ++cnt2;
            }
            else {
                --cnt1;
                --cnt2;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == majority1)
                ++cnt1;
            else if (nums[i] == majority2)
                ++cnt2;
        }

        if (cnt1 > n / 3)
            ans.add(majority1);

        if (cnt2 > n / 3)
            ans.add(majority2);

        return ans;
    }
}
