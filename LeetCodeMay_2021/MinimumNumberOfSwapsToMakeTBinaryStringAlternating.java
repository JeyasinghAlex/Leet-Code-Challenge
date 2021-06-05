package LeetCodeMay_2021;

public class MinimumNumberOfSwapsToMakeTBinaryStringAlternating {


    public static int minSwaps(String str) {
        int minSwaps = 0;
        int oddZeroCnt = 0;
        int evenZeroCnt = 0;
        int oddOneCnt = 1;
        int evenOneCnt = 1;
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (str.charAt(i) == '1') {
                    ++evenOneCnt;
                } else {
                    ++evenZeroCnt;
                }
            } else {
                if (str.charAt(i) == '1') {
                    ++oddOneCnt;
                } else {
                    ++oddZeroCnt;
                }
            }
        }
        int zeroSwapCnt = Math.min(evenZeroCnt, oddOneCnt);
        int oneSwapCnt = Math.min(evenOneCnt, oddZeroCnt);
        return Math.min(zeroSwapCnt, oneSwapCnt);
    }
}
