public class CapacityToShipPackagesWithin_D_Days {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int num : weights) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + right >>> 1;
            if (canSplit(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int sum, int m) {

        int count = 1;
        int total = 0;
        for (int num : nums) {
            total += num;
            if (total > sum) {
                total = num;
                ++count;
            }

            if (count > m) {
                return false;
            }
        }
        return true;
    }
}
