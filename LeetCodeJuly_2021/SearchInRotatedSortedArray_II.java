public class SearchInRotatedSortedArray_II {

    public boolean search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[lo] == nums[mid]) {
                ++lo;
            }
            else if (nums[mid] > nums[lo]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi - 1]) {
                    lo = mid + 1;
                } else {
                    hi  = mid;
                }
            }
        }
        return false;
    }
}
