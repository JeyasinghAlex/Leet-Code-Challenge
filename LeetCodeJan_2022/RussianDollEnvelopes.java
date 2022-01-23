import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int max = 1;
        for (int i = 1; i < n; ++i) {

            int[] a = envelopes[i];
            for (int j = 0; j < i; ++j) {
                int[] b = envelopes[j];
                if (a[0] > b[0] && a[1] > b[1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return max;
    }
}
