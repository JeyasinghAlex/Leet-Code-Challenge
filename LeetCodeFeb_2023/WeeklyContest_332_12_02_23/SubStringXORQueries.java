package WeeklyContest_332_12_02_23;

import java.util.HashMap;
import java.util.Map;

public class SubStringXORQueries {

    public int[][] substringXorQueries(String s, int[][] queries) {

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 30; i > 0; i--) {
            for (int j = s.length() - i; j >= 0; j--) {
                map.put(Integer.valueOf(s.substring(j, i + j), 2), new int[] { j, i + j - 1 });
            }
        }
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[] { -1, -1 });
        }
        return result;
    }
}
