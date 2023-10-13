package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        getAllPermutations(nums, list, ans, visited);
        return ans;
    }

    private void getAllPermutations(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] visited) {

        if (nums.length == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                getAllPermutations(nums, list, ans, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
