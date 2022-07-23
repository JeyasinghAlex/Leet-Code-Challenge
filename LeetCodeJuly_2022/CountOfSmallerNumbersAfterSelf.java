import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        int[] temp = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            int idx = lowerBond(list, nums[i]);
            list.add(idx, nums[i]);
            temp[i] = idx;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ans.add(temp[i]);
        }
        return ans;
    }


    private int lowerBond(List<Integer> list, int target) {

        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > list.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
