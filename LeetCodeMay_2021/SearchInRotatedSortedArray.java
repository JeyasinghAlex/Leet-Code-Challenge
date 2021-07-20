
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int st = 0;
        int ed = nums.length;
        while (st < ed) {
            int mid = st + ed >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > nums[st]) {
                if (target >= nums[st] && target <= nums[mid]) {
                    ed = mid;
                } else {
                    st = mid + 1;
                }
            }
            else {
                if (target >= nums[mid] && target <= nums[ed - 1]) {
                    st = mid + 1;
                } else {
                    ed = mid;
                }
            }
        }
        return -1;
    }

    public static int search_1(int[] nums, int target) {
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
