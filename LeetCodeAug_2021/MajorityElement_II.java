import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_II {

    public List<Integer> majorityElement(int[] nums) {

        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == num1) {
                ++count1;
            } else if (nums[i] == num2) {
                ++count2;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }

        List<Integer> list = new ArrayList<>();
        count1 = 0; count2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == num1) {
                ++count1;
            } else if (nums[i] == num2) {
                ++count2;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(num1);
        }
        if (count2 > nums.length / 3) {
            list.add(num2);
        }
        return list;
    }

    public List<Integer> majorityElement_1(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {

            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);

            if (!list.contains(n) && count > nums.length / 3) {
                list.add(n);
            }
        }
        return list;
    }
}
