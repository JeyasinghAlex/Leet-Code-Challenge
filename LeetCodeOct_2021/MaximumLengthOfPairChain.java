import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int[] pair : pairs) {
            if (max < pair[0]) {
                max = pair[1];
                ++count;
            }
        }
        return count;
    }
}
