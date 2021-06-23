import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            if (map.get(n) != null && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] ans = new int[list.size()];
        int idx = 0;
        for (int n : list) {
            ans[idx++] = n;
        }
        return ans;
    }

    public int[] intersect_1(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        for (int n : nums1) {
            list.add(n);
        }

        for (int n : nums2) {

            if (list.contains(n)) {
                lt.add(n);
                list.remove(new Integer(n));
            }
        }

        int[] ans = new int[lt.size()];
        int idx = 0;
        for (int n : lt) {
            ans[idx++] = n;
        }
        return ans;
    }
}
