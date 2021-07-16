import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Gold Medal");
        map.put(2, "Silver Medal");
        map.put(3, "Bronze Medal");
        TreeMap<Integer, String> rank = new TreeMap<>();

        for (int n : score) {
            rank.put(n, "");
        }
        int r = rank.size();
        for (int n : rank.keySet()) {
            if (r <= 3) {
                rank.put(n, map.get(r--));
            } else {
                rank.put(n, r-- + "");
            }
        }

        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; ++i) {
            ans[i] = rank.get(score[i]);
        }
        return ans;
    }
}
