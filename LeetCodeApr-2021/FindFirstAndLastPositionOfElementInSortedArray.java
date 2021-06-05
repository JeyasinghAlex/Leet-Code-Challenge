public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

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
