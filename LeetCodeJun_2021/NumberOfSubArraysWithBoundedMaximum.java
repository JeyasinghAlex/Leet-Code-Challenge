public class NumberOfSubArraysWithBoundedMaximum {

    public static void main(String[] args) {
        System.out.println(new NumberOfSubArraysWithBoundedMaximum().numSubarrayBoundedMax(new int[]{1,2,3,4,5,6,7,8}, 4, 7));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int st = -1;
        int ed = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] > right) {
                st = ed = i;
                continue;
            }
            if (nums[i] >= left) {
                ed = i;
            }
            ans += ed - st;
        }
        return ans;
    }
}
