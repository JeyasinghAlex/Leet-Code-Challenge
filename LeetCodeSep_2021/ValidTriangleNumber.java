import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int lo = 0;
            int hi = i - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[i]) {
                    count += (hi - lo);
                    --hi;
                } else {
                    ++lo;
                }
            }
        }
        return count;
    }
}