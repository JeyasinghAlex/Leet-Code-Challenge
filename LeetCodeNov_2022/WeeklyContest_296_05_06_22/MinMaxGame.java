package WeeklyContest_296_05_06_22;

public class MinMaxGame {

    public int minMaxGame(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] temp = new int[n / 2];

        for (int i = 0; i < n / 2; ++i) {
            if (i % 2 == 0) {
                temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(temp);
    }

    public int minMaxGame_1(int[] nums) {

        int n = nums.length;

        while (true) {
            int idx = 0;
            boolean flag = true;
            if (n == 1) {
                return nums[0];
            }
            for (int i = 0; i < n; i = i + 2) {

                if (flag) {
                    nums[idx++] = Math.min(nums[i], nums[i + 1]);
                }
                if (!flag) {
                    nums[idx++] = Math.max(nums[i], nums[i + 1]);
                }
                flag = flag ? false : true;
            }
            n = n / 2;
        }
    }
}
