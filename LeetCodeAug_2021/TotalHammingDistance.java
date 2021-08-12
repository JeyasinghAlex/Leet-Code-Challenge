public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; ++j) {
                bitCount += ((nums[j] >> i) & 1);
            }
            ans += bitCount * (nums.length - bitCount);
        }
        return ans;
    }

    public int totalHammingDistance_1(int[] nums) {

        int[] count = new int[32];
        int ans = 0;
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0, temp = nums[i]; temp != 0; ++j, temp >>>= 1) {
                count[j] += (temp & 1);
            }
        }

        for (int bitCount : count) {
            ans += bitCount * (nums.length - bitCount);
        }
        return ans;
    }
}
