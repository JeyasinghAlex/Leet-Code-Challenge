package WeeklyContest_322_04_12_22;

public class CircularSentence {

    public boolean isCircularSentence(String sentence) {

        int n = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(n - 1)) {
            return false;
        }

        String[] words = sentence.split(" ");
        int len = words.length;

        for (int i = 1; i < len; ++i) {

            int l = words[i - 1].length();
            if (words[i - 1].charAt(l - 1) != words[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
