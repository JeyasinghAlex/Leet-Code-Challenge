import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(k, n, ans, list, 1);
        return ans;
    }

    public List<List<Integer>> combinationSum3_1(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[9];
        for (int i = 1; i <= 9; ++i) {
            arr[i - 1] = i;
        }
        int len = 1 << 9;

        for (int i = 1; i < len; ++i) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            if (bitCount(i) == k) {
                for (int j = 0, temp = i; temp != 0; temp >>>= 1, ++j) {
                    if ((temp & 1) == 1) {
                        list.add(arr[j]);
                        sum += arr[j];
                    }
                }
            }
            if (sum == n) {
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

    private void backtrack(int k, int target, List<List<Integer>> ans, List<Integer> list, int start) {

        if (list.size() == k && target == 0) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        if (list.size() > k || target < 0) {
            return ;
        }

        for (int i = start; i <= 9; ++i) {

            list.add(i);
            backtrack(k, target - i, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
