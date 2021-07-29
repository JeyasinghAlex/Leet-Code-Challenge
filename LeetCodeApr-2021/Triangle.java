import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(4, 1, 8, 3));
        ans.add(Arrays.asList(6,5,7));
        ans.add(Arrays.asList(3,4));
        ans.add(Arrays.asList(2));
        System.out.println(new Triangle().minimumTot(ans));
    }

    public int minimumTot(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = 0; i < triangle.get(n - 1).size(); ++i) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal_1(List<List<Integer>> triangle) {

        int n = triangle.size() - 1;
        List<Integer> prev = triangle.get(n);

        for (int i = n - 1; i >= 0; --i) {

            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); ++j) {
                int max = curr.get(j) + Math.min(prev.get(j), prev.get(j + 1));
                curr.set(j, max);
            }
            prev = curr;
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = triangle.get(i);

            for (int j = 0; j < curr.size(); ++j) {
                if (j == 0) {
                    int ans = prev.get(j) + curr.get(j);
                    curr.set(0, ans);
                } else if (j == curr.size() - 1) {
                    int ans = curr.get(j) + prev.get(j - 1);
                    curr.set(j, ans);
                } else {
                    int ans1 = curr.get(j) + prev.get(j - 1);
                    int ans2 = curr.get(j) + prev.get(j);
                    int min = Math.min(ans1, ans2);
                    curr.set(j, min);
                }
            }
            triangle.set(i, new ArrayList<>(curr));
        }

        int min = Integer.MAX_VALUE;
        for (int a : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, a);
        }
        return min;
    }
}