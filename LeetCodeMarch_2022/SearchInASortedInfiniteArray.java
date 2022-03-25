public class SearchInASortedInfiniteArray {

    public boolean find(int[] nums, int target) {

        int lo = 0;
        int hi = 1;
        while (hi < nums.length) {

            if (lowerBond(nums, lo, hi, target)) {
                return true;
            }
            if (lo == nums.length - 1 && hi == nums.length - 1) {
                return false;
            }
            lo = hi;
            hi = (int) Math.pow(2, hi);
            if (hi > nums.length) {
                hi = nums.length - 1;
            }
        }
        return false;
    }

    public boolean lowerBond(int[] nums, int lo, int hi, int target) {

        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo < nums.length && nums[lo] == target;
    }
}
