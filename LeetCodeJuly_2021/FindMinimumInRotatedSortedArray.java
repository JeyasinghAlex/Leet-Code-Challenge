public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
