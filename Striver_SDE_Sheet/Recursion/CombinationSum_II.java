package Recursion;

import java.util.*;

public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(0, candidates, target, ans, list);
        return new ArrayList<>(ans);
    }

    private void helper(int idx, int[] nums, int target, Set<List<Integer>> ans, List<Integer> list) {

        if (target < 0)
            return;

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = idx; i < nums.length; ++i) {

            if (i != idx && nums[i] == nums[i - 1])
                continue;

            list.add(nums[i]);
            helper(i + 1, nums, target - nums[i], ans, list);
            list.remove(list.size() - 1);
        }
    }
}
