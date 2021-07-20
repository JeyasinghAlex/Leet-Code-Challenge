public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int a = lowerBond(nums, target);
        int b = upperBond(nums, target);
        if (nums.length == 0 || a >= nums.length) {
            return new int[]{-1, -1};
        }
        if (nums[a] == target) {
            return new int[]{a, b};
        }
        return new int[]{-1, -1};
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

    private int upperBond(int[] arr, int target) {

        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    public int[] searchRange_1(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int st = 0,  ed = 0;
        boolean isFind = false;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                isFind = true;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (nums.length == 0 || !isFind) {
            return new int[]{-1, -1};
        }
        st = l;
        ed = l;
        for (int i = l; i < nums.length; ++i) {
            if (nums[i] == target) {
                ed = i;
            }
        }

        return new int[]{st, ed};
    }
}
