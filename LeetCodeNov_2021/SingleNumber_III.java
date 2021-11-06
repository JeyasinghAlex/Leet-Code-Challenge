public class SingleNumber_III {

    public int[] singleNumber(int[] nums) {

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }
        return new int[] {a, aXORb ^ a};
    }

    public int[] singleNumber_1(int[] nums) {

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        xor &= -xor;

        int[] ans = new int[2];
        for (int num : nums) {

            if ((xor & num) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
