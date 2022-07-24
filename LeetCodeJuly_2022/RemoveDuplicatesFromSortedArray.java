public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[idx] != nums[i]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
