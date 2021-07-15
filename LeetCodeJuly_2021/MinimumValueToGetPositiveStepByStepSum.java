public class MinimumValueToGetPositiveStepByStepSum {

    public int minStartValue(int[] nums) {

        int sum = 0, minSum = 0;
        for (int n : nums) {
            sum += n;
            minSum = Math.min(minSum, sum);
        }
        return 1 - minSum;
    }

    public int minStartValue_1(int[] nums) {

        int min = Integer.MAX_VALUE;
        int startValue = 1;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        if (min > 0) {
            return min;
        }

        while (true) {
            int sum = startValue;
            boolean flag = true;
            for (int n : nums) {
                sum += n;
                if (sum < 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return startValue;
            }
            startValue++;
        }
    }
}
