package Arrays;

public class FindTheDuplicateNumber {

    /**
     * You must solve the problem without modifying the array nums
     */
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
