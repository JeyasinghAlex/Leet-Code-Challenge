package WeeklyContest_2_10_22;

public class MinimizeXOR {

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;

        System.out.println(new MinimizeXOR().minimizeXor(num1, num2));

    }
    public int minimizeXor(int num1, int num2) {

        int n = bitCount(num2);
        int res = 0;
        boolean[] used = new boolean[30];
        for (int i = 30; i >= 0; i--) {
            if ((num1 & 1 << i) > 0 && n > 0) {
                n--;
                num1 ^= 1 << i;
                res ^= 1 << i;
                used[i] = true;
            }
        }
        for (int i = 0; i < 30; i++) {
            if (n > 0 && !used[i] && (num1 & 1 << i) == 0) {
                num1 ^= 1 << i;
                res ^= 1 << i;
                n--;
            }
        }
        return res;
    }

    private int bitCount(int n) {

        int count = 0;
        while (n > 0) {

            if ((n & 1) == 1) {
                ++count;
            }
            n = n >>> 1;
        }
        return count;
    }
}
