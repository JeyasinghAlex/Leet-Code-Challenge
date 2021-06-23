import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        int i = 0;
        int j = 0;
        int count = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                ++count;
                ++i;
            }
            ++j;
        }
        return count;
    }
}
