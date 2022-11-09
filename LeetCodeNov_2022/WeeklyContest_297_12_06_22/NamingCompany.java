package WeeklyContest_297_12_06_22;

import java.util.HashSet;
import java.util.Set;

public class NamingCompany {

    public long distinctNames(String[] ideas) {

        Set<String>[] group = new HashSet[26];

        for (int i = 0; i < 26; ++i) {
            group[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            char ch = idea.charAt(0);
            group[ch - 'a'].add(idea.substring(1));
        }

        long ans = 0L;
        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j < 26; ++j) {

                int a = 0;
                int b = 0;

                for (String s : group[i]) {
                    if (!group[j].contains(s)) {
                        ++a;
                    }
                }

                for (String s : group[j]) {
                    if (!group[i].contains(s)) {
                        ++b;
                    }
                }
                ans += ((long) a * b);
            }
        }
        return 2 * ans;
    }
}
