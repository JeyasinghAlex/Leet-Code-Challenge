public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {

        int len = nums.length;
        int n = 1 << len; // number of combinations
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int xor = 0;
            for (int j = 0, temp = i; temp != 0; temp >>>= 1, ++j) {
                if ((temp & 1) == 1) {
                    xor = xor ^ nums[j];
                }
            }
            ans += xor;
        }
        return ans;
    }
}
