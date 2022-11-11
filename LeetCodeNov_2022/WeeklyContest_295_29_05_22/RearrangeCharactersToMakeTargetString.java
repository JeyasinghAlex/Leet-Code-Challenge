package WeeklyContest_295_29_05_22;

public class RearrangeCharactersToMakeTargetString {

    public int rearrangeCharacters(String s, String target) {

        int[] a = new int[26];
        int[] b = new int[26];

        for (char ch : s.toCharArray()) {
            a[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            b[ch - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for (char ch : target.toCharArray()) {
            ans = Math.min(ans, a[ch - 'a'] / b[ch - 'a']);
        }
        return ans;
    }
}
