import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {


    public int[] nextGreater(int[] arr, int n) {

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }

    /**
     * This method is worked on number distinct in array.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {

            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }

            int val = st.isEmpty() ? -1 : st.peek();

            map.put(nums2[i], val);

            st.push(nums2[i]);
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            boolean flag = false;
            for (int j = i + 1; j < nums2.length; ++j) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                map.put(nums2[i], -1);
            }
        }
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
