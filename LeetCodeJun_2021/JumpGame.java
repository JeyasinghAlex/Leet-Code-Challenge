package LeetCodeJun_2021;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int step = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > step) {
                return false;
            }
            step = Math.max(step, i + nums[i]);
        }
        return true;
    }
}
