import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {


    private int[] temp;
    private int[] nums;
    private Random random;
    public ShuffleAnArray(int[] nums) {
        this.temp = nums.clone();
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        for (int i = 1; i < nums.length; ++i) {
            int j = random.nextInt(i + 1);
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
