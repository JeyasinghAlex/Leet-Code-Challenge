import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;
        for (int n : aliceSizes) {
            sumA += n;
        }

        for (int n : bobSizes) {
            sumB += n;
        }

        int need = (sumB - sumA) / 2;

        Set<Integer> set = new HashSet<>();
        for (int n : bobSizes)
            set.add(n);

        for (int n : aliceSizes) {

            if (set.contains(need + n)) {
                return new int[]{n, need + n};
            }
        }
        return new int[]{};
    }
}
