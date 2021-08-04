public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n] < 0) {
                return n;
            }
            nums[n] = -nums[n];
        }
        return -1;
    }

    public int FloydTortoise(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate_1(int[] nums) {

        int max = 1000001;
        int[] temp = new int[max];
        for (int n : nums) {
            if (temp[n] < 0) {
                return n;
            }
            temp[n] = -nums[n];
        }
        return -1;
    }
}
