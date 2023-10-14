package Arrays;

public class SortColors {

    public void sortColors(int[] nums) {

        int[] colors = new int[3];
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            colors[nums[i]--]++;
        }

        int idx = 0;
        for (int i = 0; i < 3; ++i) {
            while (colors[i]-- > 0) {
                nums[idx++] = i;
            }
        }
    }
}
