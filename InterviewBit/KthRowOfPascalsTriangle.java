package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class KthRowOfPascalsTriangle {

    public int[] getRow(int A) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= A; ++i) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; ++j) {
                int sum = list.get(j) + list.get(j + 1);
                list.set(j, sum);
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
