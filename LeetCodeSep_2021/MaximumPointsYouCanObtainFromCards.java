public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int window = n - k;
        int sum = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < window; ++i) {
            sum += cardPoints[i];
        }
        int totalSum = sum;

        min = Math.min(min, sum);
        for (int i = window; i < n; ++i) {
            sum -= cardPoints[i - window];
            sum += cardPoints[i];
            totalSum += cardPoints[i];
            min = Math.min(min, sum);
        }
        return totalSum - min;
    }
}
