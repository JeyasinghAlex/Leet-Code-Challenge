public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (nums[mid + 1] > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int findPeakElement_1(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {

            int mid = lo + hi >>> 1;

            if (nums[mid - 1] > nums[mid]) {
                hi = mid;
            } else if (nums[mid + 1] > nums[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
