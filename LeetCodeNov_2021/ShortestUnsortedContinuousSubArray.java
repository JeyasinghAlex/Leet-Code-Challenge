import java.util.Stack;

public class ShortestUnsortedContinuousSubArray {

    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int l = n;
        int r = 0;

        for (int i = 0; i < n; ++i) {
            int curr = nums[i];
            while (!st.isEmpty() && nums[st.peek()] > curr) {
                l = Math.min(l, st.pop());
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; --i) {
            int curr = nums[i];
            while (!st.isEmpty() && nums[st.peek()] < curr) {
                r = Math.max(r, st.pop());
            }
            st.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}
