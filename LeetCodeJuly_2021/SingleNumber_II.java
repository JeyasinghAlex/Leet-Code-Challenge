public class SingleNumber_II {

    public int singleNumber(int[] nums) {

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {

                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            ans |= sum << i;
//            ans += sum << i;
        }
        return ans;
    }

    public int singleNumber_1(int[] nums) {

        int[] bitCount = new int[32];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0, temp = nums[i]; temp != 0; ++j, temp >>>= 1) {
                bitCount[j] += (temp & 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            if (bitCount[i] % 3 != 0) {
                ans += (1 << i);
//                ans |= (1 << i);
            }
        }
        return ans;
    }
}
