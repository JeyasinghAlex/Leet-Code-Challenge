import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; ++i) {

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int temp = Math.abs(sum - target);
                if (temp == 0) {
                    return sum;
                }
                if (temp <= min) {
                    min = temp;
                    ans = sum;
                }
                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return ans;
    }

    private void sort(int[] arr) {

        int n = arr.length;
        if (n < 2) return;
        int mid = n >>> 1;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; ++i)
            left[i] = arr[i];
        for (int i = mid; i < n; ++i)
            right[i - mid] = arr[i];

        sort(left);
        sort(right);
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

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public int threeSumClosest_1(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE - target;
        for (int i = 0; i < nums.length; ++i) {

            int lo = i + 1; int hi = nums.length - 1;
            while (lo < hi) {

                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return ans;
    }
}
