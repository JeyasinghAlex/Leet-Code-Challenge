public class UglyNumber_II {

    public int nthUglyNumber(int n) {

        int[] ugly = new int[n + 1];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i <= n; ++i) {

            int min = Math.min(ugly[index2] * 2, ugly[index3] * 3);
            min = Math.min(min, ugly[index5] * 5);
            ugly[i] = min;

            if (ugly[index2] * 2 == min) {
                ++index2;
            }
            if (ugly[index3] * 3 == min) {
                ++index3;
            }
            if (ugly[index5] * 5 == min) {
                ++index5;
            }
        }
        return ugly[n - 1];
    }
}