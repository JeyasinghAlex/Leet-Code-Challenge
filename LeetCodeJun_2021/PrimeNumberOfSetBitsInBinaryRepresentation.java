import java.util.Arrays;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {

        int[] bits = new int[32];
        boolean[] prims = new boolean[32];
        Arrays.fill(prims, true);
        for (int i = left; i <= right; ++i) {
            int temp = bitCount(i);
            bits[temp]++;
        }

        for (int i = 2; i <= Math.sqrt(32); ++i) {
            for (int j = i << 1; j < 32; j += i) {
                if (prims[j]) {
                    prims[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < 32; ++i) {
            if (prims[i]) {
                count += bits[i];
            }
        }
        return count;
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
