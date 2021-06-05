package LeetCodeMay_2021.BiWeekly;

public class ReplaceAllDigitsWithCharacters {

    public String replaceDigits(String s) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ans.append(s.charAt(i));
            } else {
                ans.append((char) (s.charAt(i - 1) + s.charAt(i) - '0'));
            }
        }
        return ans.toString();

    }
}
