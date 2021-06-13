public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

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
