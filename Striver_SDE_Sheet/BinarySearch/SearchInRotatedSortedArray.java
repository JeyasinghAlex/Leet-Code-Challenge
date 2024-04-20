package BinarySearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int n = nums.length;
        int index = getSmallestNumber(nums);
        int left = lowerBond(0, index, nums, target);
        if (nums[left] == target) {
            return left;
        }
        int right = lowerBond(index, n - 1, nums, target);
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int getSmallestNumber(int[] nums) {

        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + hi >>> 1;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }

    private int lowerBond(int lo, int hi, int[] nums, int target) {
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > nums[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}
