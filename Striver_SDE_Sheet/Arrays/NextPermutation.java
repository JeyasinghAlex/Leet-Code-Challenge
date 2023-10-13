package Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        if (n <= 1)
            return ;

        int peek = indexOfLastPeek(nums) - 1;

        if (peek != -1) {
            int idx = nextGreater(nums, nums[peek]);
            swap(nums, peek, idx);
        }
        reverse(nums, peek + 1);
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int nextGreater(int[] nums, int val) {
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > val)
                return i;
        }
        return -1;
    }

    private int indexOfLastPeek(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1])
                return i;
        }
        return 0;
    }
}
