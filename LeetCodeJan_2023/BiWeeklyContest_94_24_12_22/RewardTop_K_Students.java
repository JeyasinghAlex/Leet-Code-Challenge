package BiWeeklyContest_94_24_12_22;

import java.util.*;

public class RewardTop_K_Students {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback)), negative = new HashSet<>(Arrays.asList(negative_feedback));
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < report.length; ++i) {
            String[] words = report[i].split(" ");
            int point = 0;
            for (var word : words) {
                if (positive.contains(word)) point += 3;
                else if (negative.contains(word)) --point;
            }
            mp.put(student_id[i], point);
        }
        List<Integer> vals = new ArrayList<>();
        for (var elem : mp.entrySet()) vals.add(elem.getKey());
        Collections.sort(vals, (a, b)->(mp.get(a) != mp.get(b) ? Integer.compare(mp.get(b), mp.get(a)) : Integer.compare(a, b)));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) ans.add(vals.get(i));
        return ans;
    }
}
