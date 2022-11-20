package WeeklyContest_320_20_11_22;

public class NumberOfUnequalTripletsInArray {

    public int unequalTriplets(int[] nums) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {

                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}
