import java.util.ArrayList;
import java.util.List;

public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {

        List<String> sub = new ArrayList<>();
        List<String> nonSub = new ArrayList<>();
        int count = 0;
        for (String str : words) {
            if (sub.contains(str)) {
                ++count;
            } else if (nonSub.contains(str)) {
                continue;
            } else {
                if (isSubsequences(s, str)) {
                    ++count;
                    sub.add(str);
                } else {
                    nonSub.add(str);
                }
            }
        }

        return count;
    }

    private boolean isSubsequences(String s, String str) {

        int index = 0;
        for (char ch : str.toCharArray()) {
            index = s.indexOf(ch, index);
            if (index == -1) {
                return false;
            }
            ++index;
        }
        return true;
    }
}
