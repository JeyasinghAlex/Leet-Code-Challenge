public class RemovingMinimumAndMaximumFromArray {

    public int minimumDeletions(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int l = 0;
        int r = 0;

        for (int i = 0; i < n; ++i) {

            if (nums[i] < min) {
                min = nums[i];
                l = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                r = i;
            }
        }

        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }

        int a = (l + 1) + (n - r);
        int b = r + 1;
        int c = n - l;
        min = Math.min(a, b);
        return Math.min(min, c);
    }
}
