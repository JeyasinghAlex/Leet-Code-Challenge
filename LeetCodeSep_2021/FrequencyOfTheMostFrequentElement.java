import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int i = 0;
        long sum = 0;
        int max = 1;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while ((long) (j - i + 1) * nums[j] > sum + k) {
                sum -= nums[i++];
            }
            max = Math.max(max, (j - i + 1));
        }
        return max;
    }
}