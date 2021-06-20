import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {

            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; ++j) {
                int temp = list.get(j) + list.get(j + 1);
                list.set(j, temp);
            }

            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    public List<List<Integer>> generate_1(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        int j = 1;
        while (j < numRows) {
            List<Integer> prev = ans.get(ans.size() - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int i = 0; i < prev.size() - 1; ++i) {
                int sum = prev.get(i) + prev.get(i + 1);
                curr.add(sum);
            }
            curr.add(1);
            ans.add(curr);
            ++j;
        }
        return ans;
    }
}
