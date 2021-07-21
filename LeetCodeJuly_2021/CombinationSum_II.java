import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, ans, list, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int start) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return ;
        }

        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
