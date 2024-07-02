package InterviewBit;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class ReorderDataInLogFiles {

    public String[] reorderLogs(String[] A) {
        TreeMap<String, Queue<String>> map = new TreeMap<>();
        Queue<String> qu = new LinkedList<>();


        for (String s : A) {
            int n = s.length();
            if (s.charAt(n - 1) - '0' >= 0 && s.charAt(n - 1) - '0' <= 9) {
                qu.offer(s);
                continue;
            }

            int index = s.indexOf('-');
            String a = s.substring(0, index);
            String b = s.substring(index);
            map.putIfAbsent(b, new PriorityQueue<>());
            map.get(b).offer(a);
        }

        int idx = 0;
        for (String key : map.keySet()) {
            Queue<String> pq = map.get(key);

            while (!pq.isEmpty()) {
                A[idx++] = pq.poll() + key;
            }
        }

        while (!qu.isEmpty()) {
            A[idx++] = qu.poll();
        }
        return A;
    }
}
