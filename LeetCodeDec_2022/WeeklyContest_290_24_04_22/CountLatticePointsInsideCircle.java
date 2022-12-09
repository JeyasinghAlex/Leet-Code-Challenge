package WeeklyContest_290_24_04_22;

import java.util.HashSet;
import java.util.Set;

public class CountLatticePointsInsideCircle {

    public int countLatticePoints(int[][] circles) {

        Set<String> set = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            for (int i = x - r; i <= x + r; ++i) {
                for (int j = y - r; j <= y + r; ++j) {
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                        set.add(i + "#" + j);
                    }
                }
            }
        }
        return set.size();
    }
}
