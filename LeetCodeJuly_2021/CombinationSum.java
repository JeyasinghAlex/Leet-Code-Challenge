import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, list, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int start) {

        if (target == 0) {
            ans.add(new ArrayList(list));
            return ;
        }

        if (target < 0) {
            return ;
        }

        for (int i = start; i < candidates.length; ++i) {

            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, list, i);
            list.remove(list.size() - 1);
        }
    }
}
