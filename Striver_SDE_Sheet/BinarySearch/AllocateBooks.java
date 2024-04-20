package BinarySearch;

public class AllocateBooks {

    public int books(int[] nums, int b) {
        int n = nums.length;

        if (b > n) {
            return -1;
        }

        int lo = Integer.MAX_VALUE;
        int hi = 0;
        int ans = -1;

        for (int i = 0; i < n; ++i) {
            lo = Math.min(lo, nums[i]);
            hi += nums[i];
        }

        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (isPossible(nums, mid, b)) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }


    private boolean isPossible(int[] nums, int maxPage, int student) {

        int count = 1;
        int totalPage = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] > maxPage) {
                return false;
            }

            totalPage += nums[i];
            if (totalPage > maxPage) {
                ++count;
                totalPage = nums[i];
            }

            if (count > student) {
                return false;
            }
        }
        return true;
    }
}
