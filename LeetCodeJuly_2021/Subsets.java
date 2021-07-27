import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
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
        return ans;
    }

    public List<List<Integer>> subsets_1(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            backtrack(nums, 0, new ArrayList<>(), ans, i);
        }

        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> ans, int len) {

        if (len == list.size()) {
            ans.add(new ArrayList(list));
            return ;
        }

        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list, ans, len);
            list.remove(list.size() - 1);
        }

    }
}
