public class CountingBits {

    public int[] countBits(int n) {

        int[] res = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            res[i] = bitCount(i);
        }
        return res;
    }

    private int bitCount(int n) {

        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
