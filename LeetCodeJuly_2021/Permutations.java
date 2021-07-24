import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutations(nums, ans, list);
        return ans;
    }

    private void permutations(int[] nums, List<List<Integer>> ans, List<Integer> list) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0; i < nums.length; ++i) {

            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permutations(nums, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
