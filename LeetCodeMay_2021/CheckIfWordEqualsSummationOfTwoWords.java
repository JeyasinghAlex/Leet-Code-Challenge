package LeetCodeMay_2021;

public class CheckIfWordEqualsSummationOfTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        int len1 = firstWord.length();
        int len2 = secondWord.length();
        int len3 = targetWord.length();
        int max = Math.max(len1, len2);
        int len = Math.max(max, len3);
        int first = 0;
        int second = 0;
        int target = 0;

        for (int i = 0; i < len; ++i) {
            if (i < len1) {
                first = (first * 10) + firstWord.charAt(i) - 'a';
            }
            if (i < len2) {
                second = (second * 10) + secondWord.charAt(i) - 'a';
            }
            if (i < len3) {
                target = (target * 10) + targetWord.charAt(i) - 'a';
            }
        }

        return (first + second) == target;
    }
}
