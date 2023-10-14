package Arrays;

public class RepeatAndMissingNumberArray {

    public int[] repeatedNumber(final int[] A) {

        int n = A.length;
        int rn = getDuplicateNumber(A);
        for (int i = 0; i < n; ++i) {
            if (A[i] > 0)
                return new int[]{rn, i + 1};
        }
        return new int[]{};
    }

    private int getDuplicateNumber(int[] arr) {

        int duplicate = 0;
        for (int i = 0; i < arr.length; ++i) {
            int n = Math.abs(arr[i]) - 1;
            if (arr[n] < 0) {
                duplicate = n + 1;
                continue;
            }
            arr[n] = -arr[n];
        }
        return duplicate;
    }
}
