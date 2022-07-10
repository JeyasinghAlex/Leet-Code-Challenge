package weekly_10_7_22;

import java.util.ArrayList;
import java.util.List;

public class MovePiecesToObtainString {

    public boolean canChange(String start, String target) {

        int n = start.length();
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (start.charAt(i) != '_') {
                l1.add(new int[]{start.charAt(i), i});
            }
            if (target.charAt(i) != '_') {
                l2.add(new int[]{target.charAt(i), i});
            }
        }

        if (l1.size() != l2.size()) {
            return false;
        }

        for (int i = 0; i < l1.size(); ++i) {

            int[] s = l1.get(i);
            int[] t = l2.get(i);

            if (s[0] != t[0]) {
                return false;
            }

            if (s[0] == 'L' && s[1] < t[1]) {
                return false;
            }

            if (s[0] == 'R' && s[1] > t[1]) {
                return false;
            }
        }
        return true;
    }
}
