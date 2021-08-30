import java.util.Arrays;

public class UniqueLength_3_PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {

        int[] startOcc = new int[26];
        int[] endOcc = new int[26];
        Arrays.fill(startOcc, -1);
        Arrays.fill(endOcc, -1);
        for (int i = 0; i < s.length(); ++i) {

            char ch = s.charAt(i);
            if (startOcc[ch - 'a'] == -1) {
                startOcc[ch - 'a'] = i;
            }
            endOcc[ch - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {

            int st = startOcc[i];
            int ed = endOcc[i];
            boolean[] visited = new boolean[26];
            int count = 0;
            for (int j = st + 1; j < ed; ++j) {

                char ch = s.charAt(j);
                if (!visited[ch - 'a']) {
                    visited[ch - 'a'] = true;
                    ++count;
                }
            }
            ans += count;
        }
        return ans;
    }
}
