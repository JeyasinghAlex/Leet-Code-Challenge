package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            list.add(0, 1);
            int n = list.size();
            for (int j = 1; j < n - 1; ++j) {
                int a = list.get(j);
                int b = list.get(j + 1);
                list.set(j, a + b);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
