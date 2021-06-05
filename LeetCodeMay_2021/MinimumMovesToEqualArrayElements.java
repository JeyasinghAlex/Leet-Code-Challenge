package LeetCodeMay_2021;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }

}
