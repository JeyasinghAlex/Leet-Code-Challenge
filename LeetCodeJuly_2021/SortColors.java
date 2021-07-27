public class SortColors {

    public void sortColors(int[] nums) {

        int[] count = new int[3];
        for (int n : nums) {
            ++count[n];
        }
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; ++i) {
            int val = arr[i];
            int hole = i;
            while (hole > 0 && arr[hole - 1] > val) {
                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = val;
        }
    }
}
