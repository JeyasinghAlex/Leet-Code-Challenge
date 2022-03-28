import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        int len = 0;
        int n = s.length();
        int[] lastIndex = new int[26];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        int boundry = 0;
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            boundry = Math.max(boundry, lastIndex[ch - 'a']);
            ++len;
            if (i == boundry) {
                list.add(len);
                len = 0;
            }
        }
        return list;
    }
}
