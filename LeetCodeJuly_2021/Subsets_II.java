import java.util.*;

public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        int len = 1 << n;
        for (int i = 0; i < len; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0, temp = i; temp != 0; ++j, temp >>>= 1) {

                if ((temp & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> subsetsWithDup_1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            backtrack(nums, ans, new ArrayList<>(), 0, i);
        }
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> list, int start, int len) {

        if (len == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, ans, list, i + 1, len);
            list.remove(list.size() - 1);
        }
    }
}
