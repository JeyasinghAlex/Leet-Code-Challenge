package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public int[][] solve(int A) {

        int[][] ans = new int[A][A];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A; ++i) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; ++j) {
                int sum = list.get(j) + list.get(j + 1);
                list.set(j, sum);
            }

            int[] temp = new int[list.size()];
            for (int k = 0; k < list.size(); ++k) {
                temp[k] = list.get(k);
            }
            ans[i] = temp;
        }
        return ans;
    }
}
