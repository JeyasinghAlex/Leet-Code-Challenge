package LeetCodeMay_2021;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }

        int st = 0;
        while (list.size() > 1) {

            st = (st + k - 1) % list.size();
            list.remove(st);
        }

        return list.get(0);
    }
}
