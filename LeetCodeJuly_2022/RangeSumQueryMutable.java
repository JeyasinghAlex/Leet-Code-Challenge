public class RangeSumQueryMutable {

    private int sum = 0;
    private int[] arr;
    public RangeSumQueryMutable(int[] nums) {
        arr = nums;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
    }

    public void update(int index, int val) {
        sum -= arr[index];
        arr[index] = val;
        sum += val;
    }

    public int sumRange(int left, int right) {
        int ans = sum;
        for (int i = 0; i < left; ++i) {
            ans -= arr[i];
        }

        for (int i = right + 1; i < arr.length; ++i) {
            ans -= arr[i];
        }
        return ans;
    }
}
