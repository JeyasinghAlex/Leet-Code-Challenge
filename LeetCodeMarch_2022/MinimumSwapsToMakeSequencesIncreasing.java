import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int not_swap[] = new int[n];
        int swap[] = new int[n];
        Arrays.fill(not_swap, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        not_swap[0] = 0;
        swap[0] = 1;

        for(int i = 1; i < n; i++) {
            if(A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                not_swap[i] = not_swap[i - 1];
            }
            if(A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);
                not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], not_swap[n - 1]);
    }
}
