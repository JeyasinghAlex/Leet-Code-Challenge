public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo]){
                hi = mid;
            } else {
                --hi;
            }
        }
        return nums[lo];
    }

    public int findMin_1(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {

            while (lo < hi && nums[lo] == nums[lo + 1]) {
                ++lo;
            }
            while (hi > lo && nums[hi] == nums[hi - 1]) {
                --hi;
            }

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
