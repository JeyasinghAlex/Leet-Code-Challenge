package LeetCodeMay_2021;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] >= nums[lo]) {
                if (target <= nums[mid] && target >= nums[lo]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        return -1;
    }
}
