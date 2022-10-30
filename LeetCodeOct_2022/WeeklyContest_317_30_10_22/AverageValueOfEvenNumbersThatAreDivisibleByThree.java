package WeeklyContest_317_30_10_22;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {

    public int averageValue(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0 && nums[i] % 3 == 0) {
                ++cnt;
                sum += nums[i];

            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
