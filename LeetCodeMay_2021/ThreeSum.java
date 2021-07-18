import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        mergeSort(nums);
        for (int i = 0; i < nums.length; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {

                if (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                    --hi;
                    continue;
                }
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                } else if (sum < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return new ArrayList(set);
    }

    private void mergeSort(int[] arr) {

        int n = arr.length;
        if (n < 2) {
            return ;
        }

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

    public static List<List<Integer>> threeSum_1(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int lo = i + 1;
            int hi = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        --hi;
                    }
                } else if (sum < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return res;
    }
}
