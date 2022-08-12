import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;

        Set<List<Integer>> ans = new HashSet<>();

        mergeSort(nums);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {

                int lo = j + 1;
                int hi = n - 1;

                while (lo < hi) {

                    if (hi != n - 1 && nums[hi] == nums[hi + 1]) {
                        --hi;
                        continue;
                    }

                    long sum = (long) nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        ++lo;
                        --hi;
                    } else if (target > sum) {
                        ++lo;
                    } else {
                        --hi;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private void sort(int[] nums) {

        for (int i = 1; i < nums.length; ++i) {
            int hole = i;
            int val = nums[hole];
            while (hole > 0 && nums[hole - 1] > val) {
                nums[hole] = nums[hole - 1];
                hole--;
            }
            nums[hole] = val;
        }
    }

    private void mergeSort(int[] arr) {

        int n = arr.length;
        if (n <= 1) return ;
        int mid = n >>> 1;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; ++i)
            left[i] = arr[i];
        for (int i = mid; i < n; ++i)
            right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
