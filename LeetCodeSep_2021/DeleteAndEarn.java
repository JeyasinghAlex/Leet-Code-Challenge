public class DeleteAndEarn {

    public int maxTurbulenceSize(int[] arr) {

        int result = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 0; i < arr.length - 1; ++i) {

            if (arr[i] > arr[i + 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (arr[i] < arr[i + 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(inc, dec));
        }
        return result;
    }

    public int deleteAndEarn_1(int[] nums) {

        int n = 10001;
        int[] dp = new int[n];

        for (int num : nums) {
            dp[num] += num;
        }

        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
