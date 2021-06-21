public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; ++i) {
            cnt[nums[i]]++;
        }

        int sum = 0;
        for (int i = 0; i < 101; ++i) {
            if (cnt[i] != 0) {
                int temp = cnt[i];
                cnt[i] = sum;
                sum += temp;
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = cnt[nums[i]];
        }
        return res;
    }
}
