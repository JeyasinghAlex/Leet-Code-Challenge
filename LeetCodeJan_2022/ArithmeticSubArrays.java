import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            int left = l[i];
            int right = r[i];
            boolean res = isArithmeticSubarray(left, right, nums);
            list.add(res);
        }
        return list;
    }

    private boolean isArithmeticSubarray(int l, int r, int[] nums) {

        int n = r - l + 1;
        int[] arr = new int[n];
        int idx = 0;
        for (int i = l; i <= r; ++i) {
            arr[idx++] = nums[i];
        }

        Arrays.sort(arr);
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            ++lo;
            --hi;
        }

        int prev = 0;
        int diff = 0;
        boolean flag = true;
        for (int i = 1; i < n; ++i) {

            diff = arr[i] - arr[i - 1];
            if (flag) {
                prev = diff;
                flag = false;
            }
            if (prev != diff) {
                return false;
            }
        }
        return true;
    }
}
