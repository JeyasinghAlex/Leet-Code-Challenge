


import jdk.internal.util.xml.impl.Pair;

import java.util.HashMap;

public class RangeSumQuery_Immutable {


    private int[] arr;
    public RangeSumQuery_Immutable(int[] nums) {
        this.arr = nums;
        for (int i = 1; i < nums.length; ++i) {
            arr[i] = arr[i] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        if (left == 0) {
            return arr[right];
        }
        return arr[right] - arr[left -1];
    }

}
