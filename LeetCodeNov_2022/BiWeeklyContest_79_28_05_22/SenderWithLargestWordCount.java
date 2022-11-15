package BiWeeklyContest_79_28_05_22;

import java.util.HashMap;
import java.util.Map;

public class SenderWithLargestWordCount {

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            map.merge(senders[i], messages[i].split(" ").length, Integer::sum);
        }
        String best = "";
        int max = -1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (max < e.getValue()) {
                best = e.getKey();
                max = e.getValue();
            } else if (max == e.getValue()) {
                if (best.compareTo(e.getKey()) < 0) {
                    best = e.getKey();
                }
            }
        }
        return best;
    }
}
