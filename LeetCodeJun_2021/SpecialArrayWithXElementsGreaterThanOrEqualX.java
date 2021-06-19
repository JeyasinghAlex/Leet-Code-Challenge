import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {

        Arrays.sort(nums);
        int max = nums[nums.length - 1];

        for (int i = 0; i <= max; ++i) {

            int count = nums.length - lowerBond(nums, i);
            if (count < i) {
                return -1;
            }
            if (i >= count) {
                return i;
            }
        }
        return -1;
    }

    private int lowerBond(int[] arr, int target) {

        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;

            if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
