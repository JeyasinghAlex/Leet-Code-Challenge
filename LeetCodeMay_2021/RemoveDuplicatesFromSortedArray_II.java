public class RemoveDuplicatesFromSortedArray_II {

//    Remove Duplicates from Sorted Array(no duplicates) :
    public int removeDuplicatesUnique(int[] nums) {
        int i = 0;
        for(int n : nums)
            if(i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

//    Remove Duplicates from Sorted Array II (allow duplicates up to 2):
    public int removeDuplicates_II(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }


    //Own solution:
    private int index = 0;
    public int removeDuplicates(int[] arr) {

        int count = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == arr[i - 1]) {
                ++count;
            } else {
                int n = Math.min(count, 2);
                removeDup(arr, arr[i - 1], n);
                count = 1;
            }
        }
        int n = Math.min(count, 2);
        removeDup(arr, arr[arr.length - 1], n);
        return index;
    }

    private void removeDup(int[] arr, int temp, int n) {
        for (int i = 0; i < n; ++i) {
            arr[index++] = temp;
        }
    }
}
