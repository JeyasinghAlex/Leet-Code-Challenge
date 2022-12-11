package BiWeeklyContest_93_10_12_22;

public class FrogJump_II {

    public int maxJump(int[] stones) {

        int n = stones.length;
        if(n == 2) return stones[1];
        int ans = 0;
        for(int i = 2;i < n; ++i){
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }
}
