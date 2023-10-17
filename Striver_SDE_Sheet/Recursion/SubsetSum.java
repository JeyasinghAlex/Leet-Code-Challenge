package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static List<Integer> subsetSum(int num[]) {

        List<Integer> ans = new ArrayList<>();
        subsetSumHelper(0, 0, num, ans);
        Collections.sort(ans);
        return ans;
    }

    private static void subsetSumHelper(int idx, int sum, int[] nums, List<Integer> ans) {

        if (idx == nums.length) {
            ans.add(sum);
            return ;
        }

        subsetSumHelper(idx + 1, sum + nums[idx], nums, ans);
        subsetSumHelper(idx + 1, sum, nums, ans);
    }
}
