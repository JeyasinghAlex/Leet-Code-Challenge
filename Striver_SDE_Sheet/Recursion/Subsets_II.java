package Recursion;

import java.util.*;

public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(0, nums, list, ans);
        return new ArrayList<>(ans);
    }

    private void helper(int idx, int[] nums, List<Integer> list, Set<List<Integer>> ans) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; ++i) {

            if (i != idx && nums[i] == nums[i - 1])
                continue;

            list.add(nums[i]);
            helper(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup_1(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        int len = 1 << n;
        for (int i = 0; i < len; ++i) {

            List<Integer> list = new ArrayList<>();
            int temp = i;
            for(int j = 0; temp != 0; ++j, temp >>>= 1) {
                if ((temp & 1) == 1)
                    list.add(nums[j]);
            }
            ans.add(list);
        }
        return new ArrayList<>(ans);
    }
}
