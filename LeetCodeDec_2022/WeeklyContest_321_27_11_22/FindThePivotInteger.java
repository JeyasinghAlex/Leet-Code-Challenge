package WeeklyContest_321_27_11_22;

public class FindThePivotInteger {

    public int pivotInteger(int n) {

        int total = n * (n + 1) / 2;

        for (int i = 1; i <= n; ++i) {

            int sum = i * (i + 1) / 2;

            if (sum == (total - sum) + i) {
                return i;
            }
        }
        return -1;
    }

    public int pivotInteger_1(int n) {

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        left[1] = 1;
        for (int i = 2; i <= n; ++i) {
            left[i] = left[i - 1] + i;
        }

        right[n] = n;
        for (int i = n - 1; i >= 1; --i) {
            right[i] = right[i + 1] + i;
        }

        for (int i = 1; i <= n; ++i) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}
