import java.util.ArrayList;
import java.util.List;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {

        int[] win = new int[100001];
        int[] lost = new int[100001];
        boolean[] isLose = new boolean[100001];

        for (int[] match : matches) {
            int a = match[0];
            int b = match[1];
            win[a]++;
            lost[b]++;
            isLose[b] = true;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i < 100001; ++i) {

            if (win[i] >= 1 && !isLose[i]) {
                list1.add(i);
            }
            if (lost[i] == 1) {
                list2.add(i);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
