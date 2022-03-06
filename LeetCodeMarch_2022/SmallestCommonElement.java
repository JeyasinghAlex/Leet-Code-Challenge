import java.util.List;

public class SmallestCommonElement {

    public int smallestCommonElement(int m, int n, List<List<Integer>> mat) {

        for (int i = 0; i < n; ++i) {
            int target = mat.get(0).get(i);
            int j = 1;
            for (; j < m; ++j) {
                if (isCommon(mat.get(j), target)) {
                    continue;
                } else {
                    break;
                }
            }
            if (j == m) {
                return target;
            }
        }
        return -1;
    }

    private static boolean isCommon(List<Integer> list, int target) {

        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > list.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo < list.size() && list.get(lo) == target;
    }
}
