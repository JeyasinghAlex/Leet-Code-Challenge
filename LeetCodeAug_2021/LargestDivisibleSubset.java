import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int[] lis = new int[nums.length];
        int max = 1;
        Arrays.fill(lis, 1);

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {

                if (nums[i] % nums[j] == 0) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    if (lis[i] > max) {
                        max = lis[i];
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int prev = 1;
        for (int i = nums.length - 1; i >= 0; --i) {

            if(lis[i] == max && (prev % nums[i] == 0 || prev == 1)) {
                list.add(nums[i]);
                --max;
                prev = nums[i];
            }
        }
        return list;
    }
}
