package BiWeeklyContest_86_3_9_22;

public class StrictlyPalindromicNumber {

    public boolean isStrictlyPalindromic(int n) {

        for (int i = 2; i <= n - 2; ++i) {
            int[] arr = new int[30];
            int idx = convert(arr, n, i);
            boolean flag = isPalindromme(arr, idx);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindromme(int[] arr, int idx) {

        int st = 0;
        int ed = idx - 1;

        while (st < ed) {
            if (arr[st] != arr[ed]) {
                return false;
            }
            ++st;
            --ed;
        }
        return true;
    }

    private int convert(int[] arr, int n, int base) {

        int idx = 0;
        while (n > 0) {
            arr[idx++] = n % base;
            n = n / base;
        }
        return idx;
    }
}
