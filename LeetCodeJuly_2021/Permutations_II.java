import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutations(nums, ans, list, visited);
        return new ArrayList<>(ans);
    }

    private void permutations(int[] nums, Set<List<Integer>> ans, List<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                permutations(nums, ans, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
