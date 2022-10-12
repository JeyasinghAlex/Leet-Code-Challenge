package WeeklyContest_25_09_22;

import java.util.TreeMap;

public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            String name = names[i];
            int height = heights[i];

            map.put(height, name);
        }

        String[] ans = new String[n];
        int idx = n - 1;
        for (String name : map.values()) {
            ans[idx--] = name;
        }
        return ans;
    }
}
