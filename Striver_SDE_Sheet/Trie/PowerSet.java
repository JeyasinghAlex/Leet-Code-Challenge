package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public List<String> AllPossibleStrings(String s) {
        // Code here

        int n = s.length();
        int len = 1 << n;
        List<String> list = new ArrayList<>();

        for (int i = 1; i < len; ++i) {
            String str = "";
            for (int j = 0, temp = i; temp != 0; ++j, temp >>= 1) {
                if ((temp & 1) == 1) {
                    str += s.charAt(j);
                }
            }
            list.add(str);
        }
        Collections.sort(list);
        return list;
    }

    public List<String> AllPossibleStrings_1(String s) {
        // Code here
        List<String> a = new ArrayList<>();
        backtrack(0, "", s, a);
        Collections.sort(a);
        return a;
    }


    private void backtrack(int idx, String str, String s, List<String> list) {

        if (idx == s.length()) {
            if (!str.isEmpty())
                list.add(str);
            return;
        }

        backtrack(idx + 1, str + s.charAt(idx), s, list);

    }
}
