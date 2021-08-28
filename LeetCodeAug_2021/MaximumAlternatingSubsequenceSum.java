public class MaximumAlternatingSubsequenceSum {

    public long maxAlternatingSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        long sumPreIndexIsEven = nums[0];
        long sumPreIndexIsOdd = 0;
        long ans = nums[0];
        for(int i = 1;i<nums.length;i++){
            long nextEven = Math.max(sumPreIndexIsOdd+nums[i],sumPreIndexIsEven);
            long nextOdd = Math.max(sumPreIndexIsEven-nums[i],sumPreIndexIsOdd);
            ans = Math.max(ans,Math.max(nextEven,nextOdd));
            sumPreIndexIsEven = nextEven;
            sumPreIndexIsOdd = nextOdd;
        }
        return ans;
    }
}
