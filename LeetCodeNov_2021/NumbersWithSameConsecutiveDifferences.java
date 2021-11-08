import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {

        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }

        List<Integer> list = new ArrayList<>();

        backtracking(list, n, k, 0);
        int[] ans = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            ans[idx++] = num;
        }
        return ans;
    }

    private void backtracking(List<Integer> list, int n, int k,int num) {

        if (n == 0) {
            list.add(num);
            return ;
        }

        for (int i = 0; i < 10; ++i) {

            if (num == 0 && i == 0) {
                continue;
            } else if (num == 0 && i != 0) {
                backtracking(list, n - 1, k, i);
            } else {
                int temp = num % 10;
                int abs = Math.abs(temp - i);
                if (abs == k) {
                    backtracking(list, n - 1, k, (num * 10) + i);
                }
            }
        }
    }
}
