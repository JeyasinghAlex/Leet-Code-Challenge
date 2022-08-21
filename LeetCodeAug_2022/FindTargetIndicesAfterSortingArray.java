import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        int start = lowerBond(nums, target);
        int end = upperBond(nums, target);

        for (int i = start; i < end; ++i) {
            list.add(i);
        }

        return list;
    }

    private int upperBond(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {

            int mid = lo + hi >>> 1;

            if (target < nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int lowerBond(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {

            int mid = lo + hi >>> 1;

            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
