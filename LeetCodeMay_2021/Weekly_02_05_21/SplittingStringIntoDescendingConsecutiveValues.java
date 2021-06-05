package LeetCodeMay_2021.Weekly_02_05_21;

public class SplittingStringIntoDescendingConsecutiveValues {

    public boolean splitString(String s) {
        char[] arr = s.toCharArray();
        long val = 0;
        for (int i = 0; i + 1 < arr.length; i++) {
            int d = arr[i] - '0';
            val = val * 10 + d;

            if (canSplit(arr, val, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean canSplit(char[] arr, long prev, int k) {
        if (k == arr.length) {
            return true;
        }
        long val = 0;
        for (int i = k; i < arr.length; i++) {
            int d = arr[i] - '0';
            val = val * 10 + d;
            if (val == prev - 1 && canSplit(arr, val, i + 1)) {
                return true;
            }
            if (val >= prev) {
                return false;
            }
        }
        return false;
    }
}
