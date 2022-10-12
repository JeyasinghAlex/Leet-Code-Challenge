import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = n - 3; i >= 0; --i) {
            int a = nums[i + 2];
            int b = nums[i + 1];
            int c = nums[i];

            if (b + c > a) {
                return a + b + c;
            }
        }
        return 0;
    }
}
