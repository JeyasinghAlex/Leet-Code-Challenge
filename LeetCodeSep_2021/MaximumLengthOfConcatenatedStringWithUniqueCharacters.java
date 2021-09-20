import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    private int max = 0;
    public int maxLength(List<String> arr) {

        backtrack(arr, "", 0);
        return max;
    }

    private void backtrack(List<String> arr, String s, int index) {

        if (!isUnique(s)) {
            return ;
        }

        max = Math.max(max, s.length());

        for (int i = index; i < arr.size(); ++i) {

            backtrack(arr, s + arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String s) {

        boolean[] freq = new boolean[26];
        for (char ch : s.toCharArray()) {

            if (freq[ch - 'a']) {
                return false;
            }
            freq[ch - 'a'] = true;
        }
        return true;
    }
}
