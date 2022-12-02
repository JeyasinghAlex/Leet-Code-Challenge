
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {

        int n = s.length();
        Set<Character> set =  new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');

        int a = 0;
        int b = 0;

        for (int i = 0; i < n / 2; ++i) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(n - i - 1);
            if (set.contains(ch)) {
                ++a;
            }
            if (set.contains(ch1)) {
                ++b;
            }
        }
        return a == b;
    }
}
