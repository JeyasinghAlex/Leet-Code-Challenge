public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >>> 1;

            if (nums[mid] == nums[mid ^ 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public int singleNonDuplicate_1(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >>> 1;

            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public int singleNonDuplicate_2(int[] nums) {

        int total = 0;
        for (int n : nums) {
            total ^= n;
        }
        return total;
    }
}
