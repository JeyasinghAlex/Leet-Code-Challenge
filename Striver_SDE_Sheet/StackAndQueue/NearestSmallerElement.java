package StackAndQueue;

import java.util.Stack;

public class NearestSmallerElement {

    public int[] prevSmaller(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[i] <= st.peek())
                st.pop();

            int nextSmaller = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
            ans[i] = nextSmaller;
        }
        return ans;
    }
}
