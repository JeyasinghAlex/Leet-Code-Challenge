package InterviewBit;

public class NextPermutation {

    public int[] nextPermutation(int[] A) {

        int n = A.length;

        if (n <= 1)
            return A;

        int peek = indexOfLastPeek(A) - 1;
        if (peek != -1) {
            int idx = nextGreater(A, A[peek]);
            swap(A, peek, idx);
        }
        reverse(A, peek + 1);
        return A;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int nextGreater(int[] nums, int val) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > val)
                return i;
        }
        return 0;
    }

    private int indexOfLastPeek(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1])
                return i;
        }
        return 0;
    }
}
