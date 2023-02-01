package BiweeklyContest_95_07_01_23;

public class Find_XOR_BeautyOfArray {

    public int xorBeauty(int[] nums) {

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
