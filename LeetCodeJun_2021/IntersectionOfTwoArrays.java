import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> st = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n)){
                st.add(n);
            }
        }

        int[] ans = new int[st.size()];
        int idx = 0;
        for (int a : st) {
            ans[idx++] = a;
        }
        return ans;
    }
}
