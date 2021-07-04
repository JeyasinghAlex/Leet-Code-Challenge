import java.util.Arrays;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {

        boolean[] judge = new boolean[n + 1];
        int[] arr = new int[n + 1];
        Arrays.fill(judge, Boolean.TRUE);

        for (int[] tr : trust) {
            judge[tr[0]] = false;
            arr[tr[1]]++;
        }

        for (int i = 1; i <= n; ++i) {

            if (judge[i] && arr[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge_1(int n, int[][] trust) {

        int[] arr = new int[n + 1];

        for (int[] tr : trust) {
            arr[tr[0]]--;
            arr[tr[1]]++;
        }

        for (int i = 1; i <= n; ++i) {

            if (arr[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
