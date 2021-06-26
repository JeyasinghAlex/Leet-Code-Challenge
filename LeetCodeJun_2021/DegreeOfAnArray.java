import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = 0;
        int maxSize = 1;
        for (int i = 0; i < nums.length; ++i) {

            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
                size = map.get(nums[i]).size();
                maxSize = Math.max(maxSize, size);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n : nums) {

            List<Integer> list = map.get(n);
            int l = list.size();
            if (list.size() == maxSize) {
                min = Math.min(min, list.get(l - 1) - list.get(0) + 1);
            }
        }
        return min;
    }
}
