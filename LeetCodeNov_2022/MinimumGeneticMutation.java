import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        int step = 0;
        char[] charArr = {'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        Queue<String> qu = new LinkedList<>();

        for (String s : bank) {
            set.add(s);
        }

        qu.offer(start);

        while (!qu.isEmpty()) {

            int len = qu.size();
            ++step;

            while (len-- > 0) {

                String s = qu.poll();
                char[] arr = s.toCharArray();
                for (int i = 0; i < 8; ++i) {
                    char orgVal = arr[i];
                    for (char ch : charArr) {
                        arr[i] = ch;
                        String str = String.valueOf(arr);
                        if (str.equals(end) && set.contains(end)) {
                            return step;
                        }

                        if (!set.contains(str)) {
                            continue;
                        }

                        set.remove(str);
                        qu.offer(str);
                    }
                    arr[i] = orgVal;
                }
            }
        }
        return -1;
    }
}
