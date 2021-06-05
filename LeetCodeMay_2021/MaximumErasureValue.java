package LeetCodeMay_2021;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] arr) {

        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;
        while (i < arr.length && j < arr.length) {
            if (!set.contains(arr[j])) {
                sum += arr[j];
                max = Math.max(max, sum);
                set.add(arr[j]);
                ++j;
            } else {
                sum -= arr[i];
                set.remove(arr[i]);
                ++i;
            }
        }
        return max;
    }
}
