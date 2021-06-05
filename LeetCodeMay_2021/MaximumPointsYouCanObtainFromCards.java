package LeetCodeMay_2021;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScor(int[] cardPoints, int k) {

        /**
         * l -> left
         * r -> right
         */
        int res = 0;

        for (int i = 0; i < k; ++i) {
            res += cardPoints[i];
        }

        int max = res, l = k, r = cardPoints.length;
        while (l > 0) {
            res = res - cardPoints[--l] + cardPoints[--r];
            max = Math.max(max, res);
        }
        return max;
    }

    public int maxScore(int[] cardPoints, int k) {

        int sum = 0, len = cardPoints.length, window = 0;

        for (int i = 0; i < len; ++i) {
            sum += cardPoints[i];
            if (i < len - k) {
                window += cardPoints[i];
            }
        }

        int l = 0, r = len - k, res = sum - window;
        for (int i = r; i < len; ++i) {
            window += cardPoints[i];
            window -= cardPoints[l++];
            res = Math.max(res, sum - window);
        }
        return res;
    }
}
