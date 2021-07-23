import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        int len = 1 << n;
        int[] arr = new int[n];

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            arr[i - 1] = i;
        }

        for (int i = 1; i < len; ++i) {
            List<Integer> list = new ArrayList<>();
            if (bitCount(i) == k) {
                for (int j = 0, temp = i; temp != 0; ++j, temp >>>= 1) {
                    if ((temp & 1) == 1) {
                        list.add(arr[j]);
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }

    private int bitCount(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }


    public List<List<Integer>> combine_1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(ans, list, n, k, 1);
        return ans;

    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int n, int k, int start) {


        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; ++i) {

            list.add(i);
            backtrack(ans, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
