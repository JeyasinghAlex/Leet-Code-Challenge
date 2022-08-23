public class AllocateBooks {

    public long books(int n, int[] nums) {

        long lo = nums[0];
        long hi = 0;

        for (int i = 0; i < nums.length; ++i) {
            hi += nums[i];
        }

        long ans = -1;

        while (lo <= hi) {

            long mid = lo + hi >>> 1;

            if (isPossible(mid, n, nums)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(long mid, int students, int[] nums) {

        int count = 1;
        long pages = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (pages + nums[i] <= mid) {
                pages += nums[i];
            } else {
                ++count;

                if (count > students || nums[i] > mid) {
                    return false;
                }
                pages = nums[i];
            }
        }
        return true;
    }
}
