package StackAndQueue;

import java.util.*;

public class NextGreaterElement_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {

            while (!st.isEmpty() && nums2[i] >= st.peek())
                st.pop();

            int nextGreater = st.isEmpty() ? -1 : st.peek();
            map.put(nums2[i], nextGreater);
            st.push(nums2[i]);
        }

        n = nums1.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = map.get(nums1[i]);

        return ans;
    }
}
