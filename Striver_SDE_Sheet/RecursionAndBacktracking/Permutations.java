package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        getAllPermutations(nums, ans, list, visited);
        return ans;
    }

    private void getAllPermutations(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                getAllPermutations(nums, ans, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
